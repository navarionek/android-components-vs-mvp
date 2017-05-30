package co.netguru.android.cityscoremvp.di;

import javax.inject.Singleton;

import co.netguru.android.cityscoremvp.search.SearchComponent;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    SearchComponent plusSearchComponent();
}
