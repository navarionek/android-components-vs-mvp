package co.netguru.android.io17.di;

import javax.inject.Singleton;

import co.netguru.android.io17.search.SearchComponent;
import co.netguru.android.io17.search.SearchViewModel;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    SearchComponent plusSearchComponent();

    void inject(SearchViewModel viewModel);
}
