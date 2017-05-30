package co.netguru.android.io17.search;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import co.netguru.android.io17.data.City;
import co.netguru.android.io17.data.quality.CityRepository;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> cityNameInput = new MutableLiveData<>();
    private final LiveData<City> cityObservable;

    private CityRepository cityRepository;

    @Inject
    public SearchViewModel(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        cityObservable = Transformations.switchMap(cityNameInput, cityRepository::getCity);
    }

    public void setSearch(String cityName) {
        cityNameInput.setValue(cityName);
    }

    public LiveData<City> getCityObservable() {
        return cityObservable;
    }
}
