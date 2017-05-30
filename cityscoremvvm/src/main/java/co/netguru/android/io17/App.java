package co.netguru.android.io17;

import android.app.Application;
import android.content.Context;

import co.netguru.android.io17.di.ApplicationComponent;
import co.netguru.android.io17.di.ApplicationModule;
import co.netguru.android.io17.di.DaggerApplicationComponent;
import timber.log.Timber;

public class App extends Application {

    private ApplicationComponent appComponent;

    public static ApplicationComponent getAppComponent(Context context) {
        return ((App) context.getApplicationContext()).appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
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
