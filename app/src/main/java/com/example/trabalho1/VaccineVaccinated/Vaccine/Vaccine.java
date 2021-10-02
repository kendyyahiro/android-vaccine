package com.example.trabalho1.VaccineVaccinated.Vaccine;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity public class Vaccine {
    @PrimaryKey(autoGenerate = true) int vacinaId;

    public String nomeVacina;
    public String fabricante;
}
