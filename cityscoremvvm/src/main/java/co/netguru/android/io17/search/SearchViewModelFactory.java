package co.netguru.android.io17.search;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import co.netguru.android.io17.data.quality.CityRepository;

public class SearchViewModelFactory implements ViewModelProvider.Factory {

    private final CityRepository cityRepository;

    @Inject
    public SearchViewModelFactory(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public SearchViewModel create(Class modelClass) {
        return new SearchViewModel(cityRepository);
    }
}
