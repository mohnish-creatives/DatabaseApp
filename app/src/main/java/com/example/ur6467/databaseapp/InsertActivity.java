package com.example.ur6467.databaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    DatabaseHelper2 databaseHelper;
//    Contact cn;

    EditText txtName,txtMobile,txtEmail;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        databaseHelper= new DatabaseHelper2(this);
        System.out.println("Insert");

        txtName = (EditText) findViewById(R.id.edNameInsert);
        txtMobile = (EditText) findViewById(R.id.edMobileInsert);
        txtEmail = (EditText) findViewById(R.id.edEmailInsert);
        btnSave = (Button) findViewById(R.id.btnInsertRecord);

        btnSave.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           System.out.println("In Button click");
                                           //cn= new Contact(txtName.getText().toString(),txtMobile.getText().toString());
                                           Boolean msg= databaseHelper.insertPlate(Integer.parseInt(txtName.getText().toString()),txtMobile.getText().toString(),txtEmail.getText().toString());

                                           if (msg)
                                           {
                                               Toast.makeText(InsertActivity.this,"record saved",Toast.LENGTH_LONG).show();
                                               startActivity(new Intent(InsertActivity.this,MainActivity.class));
                                           }
                                           else
                                               Toast.makeText(InsertActivity.this,"record not saved",Toast.LENGTH_LONG).show();

                                       }
                                   }
        );


    }
}
