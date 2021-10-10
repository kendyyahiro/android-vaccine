package com.example.trabalho1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinedDatabase;

public class AddVaccineActivity extends AppCompatActivity {

    private EditText nomeVacina, nomeFabricante;
    private Button btnSalvar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccine);
        setupToolbar();

        this.nomeVacina =  findViewById(R.id.nome_vacina);
        this.nomeFabricante =  findViewById(R.id.nome_fabricante);
        this.btnSalvar =  findViewById(R.id.btn_salvar);

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nomeVacina.getText().toString().isEmpty()){
                    nomeVacina.requestFocus();
                    nomeVacina.setError("O nome é obrigatório!");
                }else if(nomeFabricante.getText().toString().isEmpty()){
                    nomeFabricante.requestFocus();
                    nomeFabricante.setError("O fabricante é obrigatório!");
                }else{
                    saveVacina(nomeVacina.getText().toString(), nomeFabricante.getText().toString());
                }
            }
        });
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle("Adicionar Vacina");
        setSupportActionBar(toolbar);
    }

    private void saveVacina(String nomeVacina, String nomeFabricante) {
        VaccineVaccinedDatabase db  = VaccineVaccinedDatabase.getInstance(this.getApplicationContext());

        Vaccine vaccine = new Vaccine(nomeVacina, nomeFabricante);
        db.vaccineDao().insert(vaccine);

        finish();
    }
}