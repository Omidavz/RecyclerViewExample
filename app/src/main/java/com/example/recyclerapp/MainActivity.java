package com.example.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    RecyclerView recyclerView ;
    VaccineModel[] myListData;

    MyAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        myListData = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine",R.drawable.vaccine1),
                new VaccineModel("Tetanus Vaccine",R.drawable.vaccine4),
                new VaccineModel("Pneumococcal Vaccine",R.drawable.vaccine5),
                new VaccineModel("Rotavirus Vaccine",R.drawable.vaccine6),
                new VaccineModel("Measles Vaccine",R.drawable.vaccine7),
                new VaccineModel("Cholera Vaccine",R.drawable.vaccine8),
                new VaccineModel("Covid-19 Vaccine",R.drawable.vaccine9)

        };

        adapter = new MyAdapter(myListData);
        adapter.setClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine name: "+myListData[pos].getTitle(), Toast.LENGTH_SHORT).show();
    }
}