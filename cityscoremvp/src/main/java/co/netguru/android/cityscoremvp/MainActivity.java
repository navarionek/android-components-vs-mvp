package co.netguru.android.cityscoremvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.netguru.android.cityscoremvp.R;
import co.netguru.android.cityscoremvp.search.SearchFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            SearchFragment searchFragment = new SearchFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_search, searchFragment)
                    .commit();
        }

    }

}