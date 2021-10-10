package com.example.trabalho1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho1.R;
import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinatedDatabase;

public class AddVaccinatedActivity extends AppCompatActivity {

    private EditText nomePessoa, cpf, idade, vacinaId;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccinated);

        this.nomePessoa =  findViewById(R.id.nome_pessoa);
        this.cpf =  findViewById(R.id.cpf);
        this.idade =  findViewById(R.id.idade);
        // this.vacinaId =  findViewById(R.id.fk_vaccinated);
        this.btnSalvar =  findViewById(R.id.btn_salvar);

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveVacinado(nomePessoa.getText().toString(), cpf.getText().toString(), Integer.parseInt(idade.getText().toString()), 1);
            }
        });
    }

    private void saveVacinado(String nomePessoa, String cpf, int idade, int vacinaId) {
        VaccineVaccinatedDatabase db  = VaccineVaccinatedDatabase.getInstance(this.getApplicationContext());

        Vaccinated vaccinated = new Vaccinated(vacinaId, nomePessoa, cpf, idade);
        db.vaccinatedDao().insert(vaccinated);

        finish();
    }
}