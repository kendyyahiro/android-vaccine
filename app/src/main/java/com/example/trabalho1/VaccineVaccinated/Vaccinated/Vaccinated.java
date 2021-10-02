package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;

@Entity(foreignKeys = @ForeignKey(entity = Vaccine.class, parentColumns = "vacinaId", childColumns = "vacinaId"))
public class Vaccinated {
    @PrimaryKey(autoGenerate = true) int numVacinado;

    public int vacinaId;
    public String nomePessoa;
    public String cpf;
    public int idade;

}
