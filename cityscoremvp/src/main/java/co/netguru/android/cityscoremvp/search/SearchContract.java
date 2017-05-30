package co.netguru.android.cityscoremvp.search;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;

import co.netguru.android.cityscoremvp.data.City;

public class SearchContract {

    interface View extends MvpLceView<City> {

    }

    interface Presenter extends MvpPresenter<View> {
        void onSearch(String cityName);
    }
}