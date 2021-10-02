package com.example.trabalho1.VaccineVaccinated.Vaccine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.trabalho1.AddVaccineActivity;
import com.example.trabalho1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VaccineFragment extends Fragment {

    private FloatingActionButton btnAddVaccine;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_vaccine, container, false);

        this.btnAddVaccine = (FloatingActionButton) view.findViewById(R.id.add_vaccine);

        this.btnAddVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(getActivity(), AddVaccineActivity.class);

                startActivity(sendIntent);
            }
        });

        return view;
    }

    public static VaccineFragment newInstance() {
        return new VaccineFragment();
    }
}
