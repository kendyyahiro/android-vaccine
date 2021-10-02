package com.example.trabalho1.VaccineVaccinated.Vaccine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.trabalho1.R;

public class VaccineFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vaccine, container, false);
    }

    public static VaccineFragment newInstance() {
        return new VaccineFragment();
    }
}
