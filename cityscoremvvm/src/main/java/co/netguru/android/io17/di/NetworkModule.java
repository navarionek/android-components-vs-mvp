package co.netguru.android.io17.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import co.netguru.android.io17.data.quality.CityApi;
import co.netguru.android.io17.data.quality.CityRepository;
import co.netguru.android.io17.data.quality.CityRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.teleport.org/api/")
                .build();
    }

    @Provides
    @Singleton
    CityApi provideCityApi(Retrofit retrofit) {
        return retrofit.create(CityApi.class);
    }

    @Provides
    @Singleton
    CityRepository provideCityRespository(CityApi cityApi) {
        return new CityRepositoryImpl(cityApi);
    }

}