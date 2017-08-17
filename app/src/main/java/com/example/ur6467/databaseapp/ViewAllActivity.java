package com.example.ur6467.databaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View.OnClickListener;


import java.util.ArrayList;

public class ViewAllActivity extends AppCompatActivity {

    MyCustomAdapter myCustomAdapter=null;
    ListView listView=null;
    DatabaseHelper2 db=null;
    ArrayList<Cars> cars=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true); //Add arrow in action bar for home activity

        db= new DatabaseHelper2(this);
//        db.insertSomeCars();
        cars=db.getData();
        myCustomAdapter= new MyCustomAdapter(this,R.layout.car_details,cars);

        listView = (ListView) findViewById(R.id.simpleListView);
        listView.setAdapter(myCustomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cars cars = (Cars) myCustomAdapter.getItem(position);

                //String item = merchandise.toString();
                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                //DetailActivity obj= new DetailActivity();
                Intent intent = new Intent(view.getContext(), UpdateActivity.class);
                //Intent intent = new Intent(obj);
                //intent.putExtra("ID",cars.ID)
             //   intent.putExtra("ID",cars.id);
                intent.putExtra("name",cars.name);
                intent.putExtra("color", cars.color);
                intent.putExtra("place", cars.place);
                System.out.println(cars.color.toString());
                //intent.putExtra("quantity", merchandise.quantity);
                //intent.putExtra("price", merchandise.price);
                startActivity(intent);
                //Log.i(TAG,"onItemClick");






               // String text = myCustomAdapter.getItem((int) id).toString().trim();//first method
               // final String text = ((TextView)view).getText();// second method
            /*    Toast.makeText(getBaseContext(), String.valueOf(id),
                        Toast.LENGTH_SHORT).show();

                Intent i=new Intent(ViewAllActivity.this,UpdateActivity.class);
                i.putExtra("hello",String.valueOf(id));
                startActivity(i);*/

            }
        });


    }
}
