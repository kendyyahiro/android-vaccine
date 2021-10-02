package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity public class Vaccinated {
    @PrimaryKey(autoGenerate = true) int numVacinado;

    public int vacinaId;
    public String nomePessoa;
    public String cpf;
    public int idade;

    public Vaccinated() { }

    public Vaccinated(int vacinaId, String nomePessoa, String cpf, int idade) {
        this.vacinaId = vacinaId;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.idade = idade;
    }
}
