package com.example.trabalho1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.trabalho1.VaccineVaccinated.Vaccinated.VaccinatedFragment;
import com.example.trabalho1.VaccineVaccinated.Vaccine.VaccineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);

        setupToolbar();
        setupFirstFragment();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle("Vacinados");
        setSupportActionBar(toolbar);
    }

    private void setupFirstFragment() {
        getSupportActionBar().setTitle("Home");
        Fragment homeFragment = HomeFragment.newInstance();
        openFragment(homeFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                getSupportActionBar().setTitle("Home");
                Fragment homeFragment = HomeFragment.newInstance();
                openFragment(homeFragment);
                break;
            case R.id.menu_vaccinated:
                getSupportActionBar().setTitle("Vacinados");
                Fragment vaccinatedFragment = VaccinatedFragment.newInstance();
                openFragment(vaccinatedFragment);
            break;
            case R.id.menu_vaccine:
                getSupportActionBar().setTitle("Vacinas");
                Fragment vaccineFragment = VaccineFragment.newInstance();
                openFragment(vaccineFragment);
            break;
        }

        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
