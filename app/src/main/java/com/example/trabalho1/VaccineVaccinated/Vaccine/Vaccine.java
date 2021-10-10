package com.example.trabalho1.VaccineVaccinated.Vaccine;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity public class Vaccine implements Serializable {
    @PrimaryKey(autoGenerate = true) public int vacinaId;

    public String nomeVacina;
    public String fabricante;

    public Vaccine(String nomeVacina, String fabricante) {
        this.nomeVacina = nomeVacina;
        this.fabricante = fabricante;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setVacinaId(int vacinaId) {
        this.vacinaId = vacinaId;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
