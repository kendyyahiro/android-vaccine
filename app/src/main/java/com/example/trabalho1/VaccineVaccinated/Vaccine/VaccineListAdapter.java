package com.example.trabalho1.VaccineVaccinated.Vaccine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;

import java.util.ArrayList;

public class VaccineListAdapter extends RecyclerView.Adapter<VaccineListAdapter.ViewHolder> {

    private ArrayList<Vaccine> localDataSet;
    public VaccineListAdapter(ArrayList<Vaccine> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vaccine_base_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTitle().setText(localDataSet.get(position).nomeVacina);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemTitle;

        public ViewHolder(View view) {
            super(view);
            itemTitle = (TextView) view.findViewById(R.id.item_title);
        }

        public TextView getTitle() {
            return itemTitle;
        }
    }

}