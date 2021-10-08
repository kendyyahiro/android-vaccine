package com.example.trabalho1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinedDatabase;

public class EditVaccineActivity extends AppCompatActivity {

    private int vacinaId;
    private EditText nomeVacina, nomeFabricante;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccine);

        Intent it = getIntent();
        Vaccine vaccine = (Vaccine) it.getSerializableExtra("vaccine");

//        this.getSupportActionBar().setTitle("Editar Vacina");

        nomeVacina =  findViewById(R.id.nome_vacina);
        nomeFabricante =  findViewById(R.id.nome_fabricante);
        btnSalvar =  findViewById(R.id.btn_salvar);

        vacinaId = vaccine.vacinaId;
        nomeVacina.setText(vaccine.nomeVacina);
        nomeFabricante.setText(vaccine.fabricante);
        btnSalvar.setText("Atualizar");

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateVaccine(vacinaId, nomeVacina.getText().toString(), nomeFabricante.getText().toString());
            }
        });
    }

    private void updateVaccine(int vacinaId, String nomeVacina, String nomeFabricante) {
        VaccineVaccinedDatabase db  = VaccineVaccinedDatabase.getInstance(this.getApplicationContext());

        Vaccine vaccine = new Vaccine(nomeVacina, nomeFabricante);
        vaccine.vacinaId = vacinaId;
        db.vaccineDao().update(vaccine);

        finish();
    }

    private Vaccine getVaccine(int id){
        VaccineVaccinedDatabase db = VaccineVaccinedDatabase.getInstance(this.getApplicationContext());

        Vaccine vaccine = db.vaccineDao().getVaccine(id);

        return vaccine;
    }
}
