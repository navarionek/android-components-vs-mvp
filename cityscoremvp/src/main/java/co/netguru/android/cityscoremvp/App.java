package co.netguru.android.cityscoremvp;

import android.app.Application;
import android.content.Context;

import co.netguru.android.cityscoremvp.di.ApplicationComponent;
import co.netguru.android.cityscoremvp.di.ApplicationModule;
import co.netguru.android.cityscoremvp.di.DaggerApplicationComponent;

public class App extends Application {

    private ApplicationComponent appComponent;

    public static ApplicationComponent getAppComponent(Context context) {
        return ((App) context.getApplicationContext()).appComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // init dagger appComponent
        this.appComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

}
