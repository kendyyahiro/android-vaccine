package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;

import java.util.ArrayList;

public class VaccinatedListAdapter extends RecyclerView.Adapter<VaccinatedListAdapter.ViewHolder> {

    private ArrayList<Vaccinated> localDataSet;
    public VaccinatedListAdapter(ArrayList<Vaccinated> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vaccine_base_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Vaccinated vaccinated = localDataSet.get(position);
        String title = String.format("%s", vaccinated.nomePessoa);
        String subtitle = String.format("Idade: %d - Vacina: %s", vaccinated.idade, vaccinated.vacinaId);
        viewHolder.getTitle().setText(title);
        viewHolder.getItemSubtitle().setText(subtitle);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemTitle;
        private final TextView itemSubtitle;

        public ViewHolder(View view) {
            super(view);
            itemTitle = (TextView) view.findViewById(R.id.item_title);
            itemSubtitle = (TextView) view.findViewById(R.id.item_subtitle);
        }

        public TextView getTitle() {
            return itemTitle;
        }
        public TextView getItemSubtitle() {
            return itemSubtitle;
        }
    }

}