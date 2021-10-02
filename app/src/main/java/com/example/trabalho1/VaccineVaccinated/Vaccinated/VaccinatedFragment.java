package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;

import java.util.ArrayList;

public class VaccinatedFragment extends Fragment {

    private RecyclerView vaccinatedList;
    private VaccinatedListAdapter vaccinatedListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vaccinated, container, false);
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
        /** CHAMAR A BUSCA DA LISTA **/
        ArrayList<Vaccinated> vaccinatedArrayList = new ArrayList<>();
        vaccinatedArrayList.add(new Vaccinated(5858, "Kendy", "055.325.687-08", 12));
        vaccinatedArrayList.add(new Vaccinated(2456, "Koji", "054.312.544-21", 25));
        vaccinatedArrayList.add(new Vaccinated(6542, "Mateus", "343.421.664-00", 06));
        /** CHAMAR A BUSCA DA LISTA **/

        vaccinatedListAdapter = new VaccinatedListAdapter(vaccinatedArrayList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireContext(), 1);

        vaccinatedList = getView().findViewById(R.id.vaccinated_list);
        vaccinatedList.setLayoutManager(layoutManager);
        vaccinatedList.setItemAnimator(new DefaultItemAnimator());
        vaccinatedList.setAdapter(vaccinatedListAdapter);
    }

    public static VaccinatedFragment newInstance() {
        return new VaccinatedFragment();
    }
}