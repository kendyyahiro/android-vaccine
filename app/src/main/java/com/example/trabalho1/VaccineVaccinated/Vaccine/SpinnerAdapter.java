package com.example.trabalho1.VaccineVaccinated.Vaccine;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Vaccine> {

    private Context context;
    private List<Vaccine> values;

    public SpinnerAdapter(@NonNull Context context, int resource, List<Vaccine> values) {
        super(context, resource, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount(){
        return values.size();
    }

    @Override
    public Vaccine getItem(int position){
        return values.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).getNomeVacina());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setText(values.get(position).getNomeVacina());

        return label;
    }

    public int getVacinaPositionById(int vacinaId){
        for(int i = 0; i < values.size(); i++){
            if(values.get(i).getVacinaId() == vacinaId){
                return i;
            }
        }
        return 0;
    }

}
