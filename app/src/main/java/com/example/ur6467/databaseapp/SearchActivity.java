package com.example.ur6467.databaseapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    EditText edID;
    TextView Email, Mobile;
    Button btnFind;
    DatabaseHelper2 db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        db= new DatabaseHelper2(this);

        Mobile = (TextView) findViewById(R.id.txtMobileSearch);
        Email= (TextView)findViewById(R.id.txtEmailSearch);
        btnFind= (Button) findViewById(R.id.btnFindSearch);
        edID= (EditText) findViewById(R.id.edNameSearch);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //Contact cn = db.getContact(edID.toString());
                Cursor cn= db.findData(edID.getText().toString());

                //Mobile.setText(cn.getName().toString());
                //Email.setText(cn.getPhoneNumber().toString());


                     //.getData(edName.getText().toString()) ){
                    Mobile.setText("Result not found");
                    System.out.println("After cursor fetch");
                    // txtEmail.setText("Hi");

                if (cn.getCount()==0) {
                    Mobile.setText("No result");
                    Email.setText("No result");
                }
else
                {
                    while (cn.moveToNext()) {
                        Mobile.setText(cn.getString(2));
                        Email.setText(cn.getString(3));
                    }

                }


            }
        });


    }
}
