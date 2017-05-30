package co.netguru.android.io17.data.quality;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;

import co.netguru.android.io17.Utils;
import co.netguru.android.io17.data.City;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityRepositoryImpl implements CityRepository {

    private final CityApi cityApi;

    @Inject
    public CityRepositoryImpl(CityApi cityApi) {
        this.cityApi = cityApi;
    }

    private String transformCityName(String name) {
        return name.toLowerCase().replace(" ", "-");
    }

    @Override
    public LiveData<City> getCity(final String cityName) {
        final MutableLiveData<City> cityMutableLiveData = new MutableLiveData<City>();
        String transformedName = transformCityName(cityName);

        cityApi.getCityInformation(transformedName).enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if (response.body() != null) {
                    City city = response.body();
                    city.setName(Utils.capitalize(cityName));
                    city.setDescription(Utils.stripHtml(city.getDescription()).toString());
                    cityMutableLiveData.setValue(city);
                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });

        return cityMutableLiveData;
    }
}
