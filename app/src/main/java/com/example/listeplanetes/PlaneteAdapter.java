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
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter {

    private final ArrayList<String> planetes;
    private MainActivity MainActivity;
    Data data = new Data();
    Button verifier = null;

    public PlaneteAdapter(Button verifier) {

        planetes = data.getListePlanetes();
        MainActivity = MainActivity.getInstance();
        verifier = this.verifier;
        verifier.setOnClickListener(verifierListener);

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
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
            }

            public void onCheckboxStatus ()
            {
                
            }
        });


        return itemView;
    }

    private View.OnClickListener verifierListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {





        }
    };


}
