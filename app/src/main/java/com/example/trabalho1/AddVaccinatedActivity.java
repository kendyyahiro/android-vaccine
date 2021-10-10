package com.example.trabalho1;

import android.os.Bundle;
import android.view.View;
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

public class AddVaccinatedActivity extends AppCompatActivity {

    private EditText nomePessoa, cpf, idade;
    private Spinner vacinaId;
    private Button btnSalvar;
    private Vaccine buscaVacinasSelecionado;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_vaccinated);

        this.nomePessoa =  findViewById(R.id.nome_pessoa);
        this.cpf =  findViewById(R.id.cpf);
        this.idade =  findViewById(R.id.idade);
        this.vacinaId =  findViewById(R.id.fk_vaccinated);
        this.btnSalvar =  findViewById(R.id.btn_salvar);

        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_item, listVaccineOptions());
        vacinaId.setAdapter(adapter);

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaVacinasSelecionado = (Vaccine) vacinaId.getSelectedItem();

                saveVacinado(nomePessoa.getText().toString(), cpf.getText().toString(), Integer.parseInt(idade.getText().toString()), buscaVacinasSelecionado.getVacinaId());
            }
        });
        setupToolbar();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle("Adicionar Vacinado");
        setSupportActionBar(toolbar);
    }

    private void saveVacinado(String nomePessoa, String cpf, int idade, int vacinaId) {
        VaccineVaccinatedDatabase db  = VaccineVaccinatedDatabase.getInstance(this.getApplicationContext());

        Vaccinated vaccinated = new Vaccinated(vacinaId, nomePessoa, cpf, idade);
        db.vaccinatedDao().insert(vaccinated);

        finish();
    }

    private List<Vaccine> listVaccineOptions(){
        VaccineVaccinatedDatabase db = VaccineVaccinatedDatabase.getInstance(this);

        List<Vaccine> vaccines = db.vaccineDao().getAll();

        return vaccines;
    }
}