package co.netguru.android.io17.search;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

import co.netguru.android.io17.App;
import co.netguru.android.io17.R;
import co.netguru.android.io17.databinding.FragmentSearchBinding;

public class SearchFragment extends LifecycleFragment {

    public static final String TAG = "SearchFragment";

    private static final int GRID_SPAN_COUNT = 2;

    SearchViewModel searchViewModel;

    @Inject
    CityQualityAdapter adapter;

    @Inject
    SearchViewModelFactory searchViewModelFactory;

    private FragmentSearchBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        App.getAppComponent(getContext()).plusSearchComponent().inject(this);
        searchViewModel = ViewModelProviders.of(this, searchViewModelFactory)
                .get(SearchViewModel.class);
        binding.setSearchViewModel(searchViewModel);

        searchViewModel.getCityObservable().observe(this, city -> {
            binding.setCity(city);
            adapter.setCity(city);
            hideKeyboard();
        });

        initRecycler();
    }

    private void initRecycler() {
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), GRID_SPAN_COUNT));
        binding.recyclerView.setAdapter(adapter);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(binding.searchField.getWindowToken(), 0);
    }

}