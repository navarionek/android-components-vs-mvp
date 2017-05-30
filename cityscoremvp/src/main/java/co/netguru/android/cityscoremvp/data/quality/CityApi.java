package co.netguru.android.cityscoremvp.data.quality;

import co.netguru.android.cityscoremvp.data.City;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CityApi {
    @GET("urban_areas/slug:{city}/scores")
    Observable<City> getCityInformation(@Path("city") String city);
}
