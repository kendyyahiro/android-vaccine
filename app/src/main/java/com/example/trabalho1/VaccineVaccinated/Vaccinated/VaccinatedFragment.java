package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.trabalho1.R;

public class VaccinatedFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vaccinated, container, false);
    }

    public static VaccinatedFragment newInstance() {
        return new VaccinatedFragment();
    }
}