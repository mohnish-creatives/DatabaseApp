package com.example.ur6467.databaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    DatabaseHelper2 databaseHelper;
    Button btnSearch;
    Button btnUpdate;
    Button btnDelete;
    Button btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper2(this);
 //       Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
   //     setSupportActionBar(myToolbar);

        btnAdd= (Button) findViewById(R.id.btnInsertMain);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                System.out.println("Main activity");
                i = new Intent(MainActivity.this,InsertActivity.class);
                startActivity(i);
            }
        });

        btnSearch= (Button) findViewById(R.id.btnSearchMain);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(i);

            }
        });

        btnUpdate = (Button) findViewById(R.id.btnViewAllMain);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, ViewAllActivity.class);startActivity(i);


            }
        });




    }
}
