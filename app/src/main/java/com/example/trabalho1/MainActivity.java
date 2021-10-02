package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalho1.VaccineVaccinated.Vaccine.Vaccine;
import com.example.trabalho1.VaccineVaccinated.Vaccine.VaccineVaccineActivity;
import com.example.trabalho1.VaccineVaccinated.VaccineVaccinedDatabase;
import com.example.trabalho1.VaccineVaccinated.Vaccinated.VaccinedActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}