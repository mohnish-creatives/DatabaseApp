package com.example.ur6467.databaseapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class UpdateActivity extends AppCompatActivity {

    EditText Color, Place;
    Button btnUpdate, btnDelete;
    DatabaseHelper2 db;
    String name;
    String color;
    String place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true); //Add arrow in action bar for home activity

        Bundle extras = getIntent().getExtras();
        if (extras== null)
        {
            return;
        }
        //final int ID=extras.getInt("ID");
        Color= (EditText)findViewById(R.id.edColorUpdate);
        Place =(EditText)findViewById(R.id.edPlaceUpdate);

        name= extras.getString("name");
        color=extras.getString("color");
        place= extras.getString("place");
        Color.setText(color.toString());
        Place.setText(place.toString());
        updateData();
        deleteData();
    }

    public void updateData()
    {
        db= new DatabaseHelper2(this);
        btnUpdate= (Button) findViewById(R.id.btnUpdateUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateData(name.toString(), Color.getText().toString(),Place.getText().toString());
                Toast.makeText(UpdateActivity.this, "Record updated", Toast.LENGTH_LONG).show();
                startActivity(new Intent(UpdateActivity.this,ViewAllActivity.class));

/*
                boolean flag=

                if (flag==true) {
                    Toast.makeText(UpdateActivity.this, "Record updated", Toast.LENGTH_LONG).show();

                } else
                    Toast.makeText(UpdateActivity.this, "Not updated", Toast.LENGTH_LONG).show();
*/

            }
        });
    }

    public void deleteData()
    {
        db= new DatabaseHelper2(this);
        btnDelete= (Button) findViewById(R.id.btnDeleteUpdate);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteData(name.toString());
                Toast.makeText(UpdateActivity.this, "Record deleted", Toast.LENGTH_LONG).show();
                startActivity(new Intent(UpdateActivity.this,ViewAllActivity.class));
            }
        });


    }
}
