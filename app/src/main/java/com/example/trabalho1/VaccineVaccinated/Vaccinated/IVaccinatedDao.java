package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;

import java.util.List;

@Dao public interface IVaccinatedDao {
    @Query("SELECT * FROM vaccinated")
    List<Vaccinated> getAll();

    @Query("SELECT * FROM vaccinated WHERE vacinaId = :vacinaId")
    List<Vaccinated> getListVaccinatedByVaccine(int vacinaId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Vaccinated vaccinated);

    @Update
    int update(Vaccinated vaccinated);

    @Delete
    void delete(Vaccinated vaccinated);
}
