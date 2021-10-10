package com.example.trabalho1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinedDatabase;

public class EditVaccineActivity extends AppCompatActivity {

    private int vacinaId;
    private EditText nomeVacina, nomeFabricante;
    private Button btnSalvar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_vaccine);
        setupToolbar();

        Intent it = getIntent();
        Vaccine vaccine = (Vaccine) it.getSerializableExtra("vaccine");

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
                if(nomeVacina.getText().toString().isEmpty()){
                    nomeVacina.requestFocus();
                    nomeVacina.setError("O nome é obrigatório!");
                }else if(nomeFabricante.getText().toString().isEmpty()){
                    nomeFabricante.requestFocus();
                    nomeFabricante.setError("O fabricante é obrigatório!");
                }else{
                    updateVaccine(vacinaId, nomeVacina.getText().toString(), nomeFabricante.getText().toString());
                }
            }
        });
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle("Editar Vacina");
        setSupportActionBar(toolbar);
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
