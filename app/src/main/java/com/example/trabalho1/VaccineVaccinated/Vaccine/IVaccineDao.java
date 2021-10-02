package com.example.trabalho1.VaccineVaccinated.Vaccine;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;

import java.util.List;

@Dao public interface IVaccineDao {
    @Query("SELECT * FROM vaccine")
    List<Vaccine> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Vaccine vaccine);

    @Update
    int update(Vaccine vaccine);

    @Delete
    void delete(Vaccine vaccine);
}
