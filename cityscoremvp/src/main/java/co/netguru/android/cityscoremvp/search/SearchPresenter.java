package co.netguru.android.cityscoremvp.search;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import javax.inject.Inject;

import co.netguru.android.cityscoremvp.data.quality.CityController;
import co.netguru.android.cityscoremvp.di.FragmentScope;
import retrofit2.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

@FragmentScope
public class SearchPresenter extends MvpBasePresenter<SearchContract.View>
        implements SearchContract.Presenter {

    private final CityController cityController;
    private final CompositeSubscription subscriptions = new CompositeSubscription();

    @Inject
    SearchPresenter(CityController cityController) {
        this.cityController = cityController;
    }

    @Override
    public void attachView(SearchContract.View view) {
        super.attachView(view);
    }

    @Override
    public void onSearch(String cityName) {
        getView().showLoading(false);

        subscriptions.add(cityController.getCityByName(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::setData, this::handleError));
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        subscriptions.clear();
    }

    private void handleError(Throwable throwable) {
        String message;
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            if (httpException.code() == 404) {

                message = "Could not find that city";
            } else {
                message = "Unknown error";
            }
        } else {
            message = "Unknown error";
        }

        getView().showError(new Throwable(message, throwable), false);
    }
}
