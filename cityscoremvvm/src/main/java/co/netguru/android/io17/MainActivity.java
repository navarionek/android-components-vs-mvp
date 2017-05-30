package co.netguru.android.io17;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.netguru.android.io17.search.SearchFragment;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            SearchFragment searchFragment = new SearchFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_search, searchFragment, SearchFragment.TAG)
                    .commit();
        }

        getLifecycle().addObserver(new MyObserver(getLifecycle()));
    }
}