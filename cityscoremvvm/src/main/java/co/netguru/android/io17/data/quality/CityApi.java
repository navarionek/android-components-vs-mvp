package co.netguru.android.io17.data.quality;

import co.netguru.android.io17.data.City;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CityApi {
    @GET("urban_areas/slug:{city}/scores")
    Call<City> getCityInformation(@Path("city") String city);
}
