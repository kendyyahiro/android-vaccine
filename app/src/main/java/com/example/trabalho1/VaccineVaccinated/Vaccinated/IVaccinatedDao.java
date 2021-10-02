package com.example.trabalho1.VaccineVaccinated.Vaccinated;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao public interface IVaccinatedDao {
    @Query("SELECT * FROM vaccinated")
    List<Vaccinated> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Vaccinated vaccinated);

    @Update
    int update(Vaccinated vaccinated);

    @Delete
    void delete(Vaccinated vaccinated);
}
