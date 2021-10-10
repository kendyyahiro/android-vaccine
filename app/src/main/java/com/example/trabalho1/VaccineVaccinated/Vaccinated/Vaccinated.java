package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;

import java.io.Serializable;

@Entity (foreignKeys = @ForeignKey(entity = Vaccinated.class,
        parentColumns = "numVacinado",
        childColumns = "vacinaId",
        onDelete = CASCADE),
        indices={@Index(value="vacinaId", unique = true)})
public class Vaccinated implements Serializable {
    @PrimaryKey(autoGenerate = true) public int numVacinado;

    public int vacinaId;
    public String nomePessoa;
    public String cpf;
    public int idade;

    public Vaccinated(int vacinaId, String nomePessoa, String cpf, int idade) {
        this.vacinaId = vacinaId;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.idade = idade;
    }
}
