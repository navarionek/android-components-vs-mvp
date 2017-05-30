package co.netguru.android.cityscoremvp.search;

import co.netguru.android.cityscoremvp.di.FragmentScope;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent
public interface SearchComponent {
    SearchPresenter getPresenter();
}
