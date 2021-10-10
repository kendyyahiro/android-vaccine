package com.example.trabalho1.VaccineVaccinated.Vaccinated;

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

import com.example.trabalho1.AddVaccinatedActivity;
import com.example.trabalho1.AddVaccineActivity;
import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VaccinatedFragment extends Fragment {

    private FloatingActionButton btnAddVaccinated;
    private RecyclerView vaccinatedList;
    private VaccinatedListAdapter vaccinatedListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_vaccinated, container, false);

        this.btnAddVaccinated = (FloatingActionButton) view.findViewById(R.id.add_vaccinated);

        this.btnAddVaccinated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(getActivity(), AddVaccinatedActivity.class);

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
        List<Vaccinated> vaccinateds = getListVaccinated();

        vaccinatedListAdapter = new VaccinatedListAdapter(vaccinateds);
        LayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);

        vaccinatedList = getView().findViewById(R.id.vaccinated_list);
        vaccinatedList.setLayoutManager(layoutManager);
        vaccinatedList.setItemAnimator(new DefaultItemAnimator());
        vaccinatedList.setAdapter(vaccinatedListAdapter);
    }

    public List<Vaccinated> getListVaccinated(){
        VaccineVaccinatedDatabase db = VaccineVaccinatedDatabase.getInstance(getActivity());

        List<Vaccinated> vaccinateds = db.vaccinatedDao().getAll();

        return vaccinateds;
    }

    public static VaccinatedFragment newInstance() {
        return new VaccinatedFragment();
    }

}
