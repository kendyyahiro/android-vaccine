package com.example.trabalho1.VaccineVaccinated.Vaccine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.example.trabalho1.AddVaccineActivity;
import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VaccineFragment extends Fragment {

    private FloatingActionButton btnAddVaccine;
    private RecyclerView vaccineList;
    private VaccineListAdapter vaccineListAdapter;

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

    @Override
    public void onResume() {
        super.onResume();
        setupList();
    }

    @Override
    public void onPause() {
        super.onPause();
        setupList();
    }

    private void setupList() {
        List<Vaccine> vaccines = getListVaccine();

        vaccineListAdapter = new VaccineListAdapter(vaccines);
        LayoutManager layoutManager = new GridLayoutManager(requireContext(), 1);

        vaccineList = getView().findViewById(R.id.vaccine_list);
        vaccineList.setLayoutManager(layoutManager);
        vaccineList.setItemAnimator(new DefaultItemAnimator());
        vaccineList.setAdapter(vaccineListAdapter);
    }

    public List<Vaccine> getListVaccine(){
        VaccineVaccinatedDatabase db = VaccineVaccinatedDatabase.getInstance(getActivity());

        List<Vaccine> vaccines = db.vaccineDao().getAll();

        return vaccines;
    }

    public static VaccineFragment newInstance() {
        return new VaccineFragment();
    }
}
