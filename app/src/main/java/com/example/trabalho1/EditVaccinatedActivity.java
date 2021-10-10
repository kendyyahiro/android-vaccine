package com.example.trabalho1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;

public class EditVaccinatedActivity extends AppCompatActivity {

    private int numVacinado;
    private EditText nomePessoa, cpf, idade, vacinaId;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccinated);

        Intent it = getIntent();
        Vaccinated vaccinated = (Vaccinated) it.getSerializableExtra("vaccinated");

//        this.getSupportActionBar().setTitle("Editar Vacina");

        nomePessoa =  findViewById(R.id.nome_pessoa);
        cpf =  findViewById(R.id.cpf);
        idade =  findViewById(R.id.idade);
        // this.vacinaId =  findViewById(R.id.fk_vaccinated);
        btnSalvar =  findViewById(R.id.btn_salvar);

        numVacinado = vaccinated.numVacinado;
        nomePessoa.setText(vaccinated.nomePessoa);
        idade.setText(Integer.toString(vaccinated.idade));
        cpf.setText(vaccinated.cpf);
        btnSalvar.setText("Atualizar");

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateVaccinated(numVacinado, nomePessoa.getText().toString(), cpf.getText().toString(), Integer.parseInt(idade.getText().toString()) , 1);

            }
        });
    }

    private void updateVaccinated(int numVacinado, String nomePessoa, String cpf, int idade, int vacinaId) {
        VaccineVaccinatedDatabase db  = VaccineVaccinatedDatabase.getInstance(this.getApplicationContext());

        Vaccinated vaccinated = new Vaccinated(vacinaId, nomePessoa, cpf, idade);
        vaccinated.numVacinado = numVacinado;
        db.vaccinatedDao().update(vaccinated);

        finish();
    }

    // private Vaccinated getVaccinated(int id){
    //     VaccineVaccinatedDatabase db = VaccineVaccinatedDatabase.getInstance(this.getApplicationContext());

    //     Vaccinated vaccinated = db.vaccinatedDao().getVaccinated(id);

    //     return vaccinated;
    // }
}
