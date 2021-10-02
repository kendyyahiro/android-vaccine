package com.example.trabalho1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinedDatabase;

public class AddVaccineActivity extends AppCompatActivity {

    private EditText nomeVacina, nomeFabricante;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccine);

//        getSupportActionBar().setTitle("Adicionar Vacina");

        this.nomeVacina =  findViewById(R.id.nome_vacina);
        this.nomeFabricante =  findViewById(R.id.nome_fabricante);
        this.btnSalvar =  findViewById(R.id.btn_salvar);

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveVacina(nomeVacina.getText().toString(), nomeFabricante.getText().toString());
            }
        });
    }

    private void saveVacina(String nomeVacina, String nomeFabricante) {
        VaccineVaccinedDatabase db  = VaccineVaccinedDatabase.getInstance(this.getApplicationContext());

        Vaccine vaccine = new Vaccine(nomeVacina, nomeFabricante);
        db.vaccineDao().insert(vaccine);

        finish();
    }
}