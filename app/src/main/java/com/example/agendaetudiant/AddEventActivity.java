package com.example.agendaetudiant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEventActivity extends AppCompatActivity {

    EditText etTitle, etDate;
    Spinner spinnerType;
    Button btnSave;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        etTitle = findViewById(R.id.et_title);
        etDate = findViewById(R.id.et_date);
        spinnerType = findViewById(R.id.spinner_type);
        btnSave = findViewById(R.id.btn_save);
        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString();
            String date = etDate.getText().toString();
            String type = spinnerType.getSelectedItem().toString();

            if (!title.isEmpty() && !date.isEmpty()) {
                db.addEvent(title, date, type);
                finish();
            } else {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
