package co.netguru.android.io17.search;

import co.netguru.android.io17.di.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface SearchComponent {
    void inject(SearchFragment searchFragment);
}
