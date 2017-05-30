package co.netguru.android.io17.data.quality;

import android.arch.lifecycle.LiveData;

import co.netguru.android.io17.data.City;

public interface CityRepository {
    LiveData<City> getCity(String cityName);
}
