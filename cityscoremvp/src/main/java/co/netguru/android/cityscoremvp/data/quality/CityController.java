package co.netguru.android.cityscoremvp.data.quality;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.netguru.android.cityscoremvp.data.City;
import rx.Observable;

import static co.netguru.android.cityscoremvp.Utils.capitalize;

@Singleton
public class CityController {

    private final CityApi cityApi;

    @Inject
    public CityController(CityApi cityApi) {
        this.cityApi = cityApi;
    }

    public Observable<City> getCityByName(String name) {
        String transformedName = transformCityName(name);
        return cityApi.getCityInformation(transformedName)
                .cache()
                .map(city -> {
                    city.setName(capitalize(name));
                    return city;
                });
    }

    private String transformCityName(String name) {
        return name.toLowerCase().replace(" ", "-");
    }
}
