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

        this.nomeVacina =  findViewById(R.id.nome_vacina);
        this.nomeFabricante =  findViewById(R.id.nome_fabricante);
        this.btnSalvar =  findViewById(R.id.btn_salvar);

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(nomeVacina.getText().toString(), nomeFabricante.getText().toString());
            }
        });
    }

    private void saveNewUser(String nomeVacina, String nomeFabricante) {
        VaccineVaccinedDatabase db  = VaccineVaccinedDatabase.getInstance(this.getApplicationContext());

        Vaccine vaccine = new Vaccine();
        vaccine.nomeVacina = nomeVacina;
        vaccine.fabricante = nomeFabricante;
        db.vaccineDao().insert(vaccine);

        finish();
    }
}