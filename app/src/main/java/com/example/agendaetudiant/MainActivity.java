package com.example.agendaetudiant;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    RecyclerView recyclerView;
    EventAdapter adapter;
    ArrayList<Event> eventList = new ArrayList<>();
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btn_add);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadEvents();

        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, AddEventActivity.class);
            startActivity(i);
        });
    }

    private void loadEvents() {
        Cursor cursor = db.getAllEvents();
        eventList.clear();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String date = cursor.getString(2);
                String type = cursor.getString(3);
                Event ev = new Event(id, title, date, type);
                eventList.add(ev);
            } while (cursor.moveToNext());
        }
        adapter = new EventAdapter(this, eventList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEvents();
    }
}
