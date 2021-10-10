package com.example.trabalho1.VaccineVaccinated;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trabalho1.VaccineVaccinated.Vaccinated.IVaccinatedDao;
import com.example.trabalho1.VaccineVaccinated.Vaccinated.Vaccinated;
import com.example.trabalho1.VaccineVaccinated.Vaccine.IVaccineDao;
import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;

@Database(entities = {Vaccine.class, Vaccinated.class}, version = 2)
public abstract class VaccineVaccinatedDatabase extends RoomDatabase {
    private static volatile VaccineVaccinatedDatabase instance;

   public static synchronized VaccineVaccinatedDatabase getInstance(Context context){
       if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
           VaccineVaccinatedDatabase.class, "PostoX")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
       }
       return instance;
   }

    public abstract IVaccineDao vaccineDao();
    public abstract IVaccinatedDao vaccinatedDao();
}