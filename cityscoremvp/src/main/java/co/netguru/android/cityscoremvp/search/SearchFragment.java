package co.netguru.android.cityscoremvp.search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.RetainingLceViewState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.netguru.android.cityscoremvp.App;
import co.netguru.android.cityscoremvp.R;
import co.netguru.android.cityscoremvp.Utils;
import co.netguru.android.cityscoremvp.data.City;

public class SearchFragment extends MvpLceViewStateFragment<RelativeLayout, City,
        SearchContract.View, SearchContract.Presenter>
        implements SearchContract.View {

    private final CityQualityAdapter adapter = new CityQualityAdapter();

    @BindView(R.id.search_field)
    EditText searchField;

    @BindView(R.id.contentView)
    RelativeLayout resultLayout;

    @BindView(R.id.loadingView)
    ProgressBar progressBar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.city_name)
    TextView cityNameTextView;

    @BindView(R.id.city_score)
    TextView cityScoreTextView;

    @BindView(R.id.city_description)
    TextView cityDescriptionTextView;

    private Unbinder unbinder;

    @OnClick(R.id.search_button)
    void onSearchClick() {
        getPresenter().onSearch(searchField.getText().toString());
        hideKeyboard();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initRecycler();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public SearchContract.Presenter createPresenter() {
        return App.getAppComponent(getActivity()).plusSearchComponent().getPresenter();
    }

    @Override
    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public City getData() {
        return adapter.getData();
    }

    @Override
    public void setData(City city) {
        cityNameTextView.setText(city.getName());
        cityScoreTextView.setText("City score: " + String.format("%.02f", city.getScore()));
        cityDescriptionTextView.setText(Utils.stripHtml(city.getDescription()));
        adapter.setCity(city);
        showContent();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        // no-op
    }

    @NonNull
    @Override
    public LceViewState<City, SearchContract.View> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return e.getLocalizedMessage();
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchField.getWindowToken(), 0);
    }
}
