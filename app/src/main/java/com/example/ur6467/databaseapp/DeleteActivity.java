package com.example.ur6467.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText Mobile;
    DatabaseHelper db;
    Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Mobile= (EditText) findViewById(R.id.edMobileDelete);
        btnDelete= (Button) findViewById(R.id.btnDeleteDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db= new DatabaseHelper(DeleteActivity.this);
                db.deleteData(Mobile.toString());
            }
        });

    }
}
