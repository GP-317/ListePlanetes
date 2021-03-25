package com.example.listeplanetes;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class PlaneteAdapter extends BaseAdapter {

    private final ArrayList<String> planetes;
    private MainActivity MainActivity;
    Data data = new Data();
    Button verifier;
    private int nbSpin = 0;


    public PlaneteAdapter(Button verifier) {

        planetes = data.getListePlanetes();
        MainActivity = MainActivity.getInstance();
        this.verifier = verifier;

    }

    @Override
    public int getCount()
    {
        return planetes.size();
    }

    @Override
    public Object getItem(int arg0)
    {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) MainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(planetes.get(position));


        String[] taillePlanetes = data.getTaillePlanetes();

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(MainActivity, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);

                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                    nbSpin++;
                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                    nbSpin--;
                }

                if(nbSpin == data.getTaillePlanetes().length)
                {
                    verifier.setEnabled(true);
                }

                else
                {
                    verifier.setEnabled(false);
                }
            }

        });


        return itemView;
    }



}
