package com.example.trabalho1.VaccineVaccinated.Vaccine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.AddVaccineActivity;
import com.example.trabalho1.EditVaccineActivity;
import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VaccineListAdapter extends RecyclerView.Adapter<VaccineListAdapter.ViewHolder> {

    private List<Vaccine> localDataSet;
    public VaccineListAdapter(List<Vaccine> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vaccine_base_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Vaccine vaccine = (Vaccine) localDataSet.get(position);
        String vaccineName = String.format("#%d - %s", vaccine.vacinaId, vaccine.nomeVacina);
        viewHolder.getTitle().setText(vaccineName);
        viewHolder.getItemSubtitle().setText(vaccine.fabricante);
        viewHolder.getItemEdit().setOnClickListener(getEditClickListener(vaccine));
        viewHolder.getItemDelete().setOnClickListener(getDeleteClickListener(vaccine, position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    private View.OnClickListener getEditClickListener(final Vaccine vaccine) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditVaccineActivity.class);
                intent.putExtra("vaccine", (Serializable) vaccine);
                view.getContext().startActivity(intent);
            }
        };
    }

    private View.OnClickListener getDeleteClickListener(final Vaccine vaccine, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), R.style.AlertDialog);

                builder
                    .setTitle("Atenção")
                    .setMessage("Você deseja remover o item?")
                    .setCancelable(false)
                    .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            VaccineVaccinatedDatabase db  = VaccineVaccinatedDatabase.getInstance(view.getContext());

                            List<Vaccinated> vaccinated = db.vaccinatedDao().getListVaccinatedByVaccine(vaccine.vacinaId);

                            if(vaccinated.isEmpty()){
                                db.vaccineDao().delete(vaccine);
                                localDataSet.remove(position);
                                notifyDataSetChanged();

                                Toast.makeText(view.getContext(), "Removido com sucesso!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(view.getContext(), "Esse item não pode ser removido. Essa vacina já foi utilizada por algum vacinado", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

                builder.show();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemTitle;
        private final TextView itemSubtitle;
        private final ImageButton itemEdit, ItemDelete;

        public ViewHolder(View view) {
            super(view);
            itemTitle = (TextView) view.findViewById(R.id.item_title);
            itemSubtitle = (TextView) view.findViewById(R.id.item_subtitle);
            itemEdit = (ImageButton) view.findViewById(R.id.item_edit);
            ItemDelete = (ImageButton) view.findViewById(R.id.item_delete);
        }

        public TextView getTitle() {return itemTitle;}
        public TextView getItemSubtitle() {
            return itemSubtitle;
        }
        public ImageButton getItemEdit() {
            return itemEdit;
        }
        public ImageButton getItemDelete() {
            return ItemDelete;
        }
    }

}