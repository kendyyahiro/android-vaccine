package com.example.trabalho1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;
import com.example.trabalho1.VaccineVaccinated.Vaccine.SpinnerAdapter;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;

import java.util.List;

public class EditVaccinatedActivity extends AppCompatActivity {

    private int numVacinado;
    private EditText nomePessoa, cpf, idade;
    private Spinner vacinaId;
    private Button btnSalvar;
    private Vaccine buscaVacinasSelecionado;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_vaccinated);

        Intent it = getIntent();
        Vaccinated vaccinated = (Vaccinated) it.getSerializableExtra("vaccinated");

        nomePessoa =  findViewById(R.id.nome_pessoa);
        cpf =  findViewById(R.id.cpf);
        idade =  findViewById(R.id.idade);
        vacinaId =  findViewById(R.id.fk_vaccinated);
        btnSalvar =  findViewById(R.id.btn_salvar);

        SpinnerAdapter adapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, listVaccineOptions());
        vacinaId.setAdapter(adapter);

        numVacinado = vaccinated.numVacinado;
        nomePessoa.setText(vaccinated.nomePessoa);
        idade.setText(Integer.toString(vaccinated.idade));
        cpf.setText(vaccinated.cpf);
        vacinaId.setSelection(adapter.getVacinaPositionById(vaccinated.vacinaId));

        btnSalvar.setText("Atualizar");

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaVacinasSelecionado = (Vaccine) vacinaId.getSelectedItem();
                updateVaccinated(numVacinado, nomePessoa.getText().toString(), cpf.getText().toString(), Integer.parseInt(idade.getText().toString()), buscaVacinasSelecionado.getVacinaId());

            }
        });
        setupToolbar();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle("Editar Vacinado");
        setSupportActionBar(toolbar);
    }

    private void updateVaccinated(int numVacinado, String nomePessoa, String cpf, int idade, int vacinaId) {
        VaccineVaccinatedDatabase db  = VaccineVaccinatedDatabase.getInstance(this.getApplicationContext());

        Vaccinated vaccinated = new Vaccinated(vacinaId, nomePessoa, cpf, idade);
        vaccinated.numVacinado = numVacinado;
        db.vaccinatedDao().update(vaccinated);

        finish();
    }

    private List<Vaccine> listVaccineOptions(){
        VaccineVaccinatedDatabase db = VaccineVaccinatedDatabase.getInstance(this);

        List<Vaccine> vaccines = db.vaccineDao().getAll();

        return vaccines;
    }
}
