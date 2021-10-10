package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.AddVaccinatedActivity;
import com.example.trabalho1.EditVaccinatedActivity;
import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.Vaccine.VaccineListAdapter;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.List;

public class VaccinatedListAdapter extends RecyclerView.Adapter<VaccinatedListAdapter.ViewHolder> {

    private List<Vaccinated> localDataSet;
    private Context context;
    public VaccinatedListAdapter(List<Vaccinated> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vaccinated_base_list, viewGroup, false);
        context = view.getContext();
        return new VaccinatedListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Vaccinated vaccinated = (Vaccinated) localDataSet.get(position);
        String title = String.format("%s", vaccinated.nomePessoa);
        String subtitle = String.format("Idade: %d - Vacina: %s", vaccinated.idade, vaccineName(vaccinated.vacinaId));
        viewHolder.getTitle().setText(title);
        viewHolder.getItemSubtitle().setText(subtitle);
        viewHolder.getItemEdit().setOnClickListener(getEditClickListener(vaccinated));
        viewHolder.getItemDelete().setOnClickListener(getDeleteClickListener(vaccinated, position));


    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

        private View.OnClickListener getEditClickListener(final Vaccinated vaccinated) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), EditVaccinatedActivity.class);
                    intent.putExtra("vaccinated", (Serializable) vaccinated);
                    view.getContext().startActivity(intent);
                }
            };
        }

    private View.OnClickListener getDeleteClickListener(final Vaccinated vaccinated, final int position) {
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

                                db.vaccinatedDao().delete(vaccinated);
                                localDataSet.remove(position);
                                notifyDataSetChanged();

                                Toast.makeText(view.getContext(), "Removido com sucesso!", Toast.LENGTH_SHORT).show();
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

    private String vaccineName(int vacinaId){
        VaccineVaccinatedDatabase db = VaccineVaccinatedDatabase.getInstance(context);

        String vaccineName = db.vaccineDao().getVaccine(vacinaId).getNomeVacina();
        return vaccineName;
    }
}