package com.example.ur6467.databaseapp;

/**
 * Created by ur6467 on 8/1/2017.
 */


        import android.content.Context;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by Nihal on 1/24/2017.
 */

public class MyCustomAdapter extends ArrayAdapter{
    private Context context;
    private ArrayList<Cars> car;

    public MyCustomAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context,textViewResourceId, objects);

        this.context= context;
        car=objects;

    }

    private class ViewHolder
    {
        TextView carName;
        TextView carColor;
        TextView carPlace;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder=null;
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.car_details, null);

            holder = new ViewHolder();
            holder.carColor = (TextView) convertView.findViewById(R.id.carColor);
            holder.carName = (TextView) convertView.findViewById(R.id.carName);
            holder.carPlace=(TextView)convertView.findViewById(R.id.carPlace);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cars individualCar= car.get(position);
        holder.carPlace.setText("Car Place: " +  individualCar.getPlace() + "");
        holder.carName.setText("Car Name: "+ individualCar.getName()+"");
        holder.carColor.setText("Car Color: "+individualCar.getColor());
        return convertView;


    }
}