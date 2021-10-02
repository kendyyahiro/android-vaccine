package com.example.trabalho1.VaccineVaccinated;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trabalho1.VaccineVaccinated.Vaccinated.IVaccinatedDao;
import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;
import com.example.trabalho1.VaccineVaccinated.Vaccine.IVaccineDao;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;

@Database(entities = {Vaccine.class, Vaccinated.class}, version = 1)
public abstract class VaccineVaccinedDatabase extends RoomDatabase {
    private static volatile VaccineVaccinedDatabase instance;

   public static synchronized VaccineVaccinedDatabase getInstance(Context context){
       if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
           VaccineVaccinedDatabase.class, "PostoX")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
       }
       return instance;
   }

    public abstract IVaccineDao vaccineDao();
    public abstract IVaccinatedDao vaccinatedDao();
}