package com.example.listeplanetes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    ListView listview;
    PlaneteAdapter adapter;
    Button verifier;
    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifier = (Button)findViewById(R.id.btnVerify);
        verifier.setEnabled(false);

        instance = this;

        listview = (ListView) findViewById(R.id.listView);
        //adapter = new PlaneteAdapter();

        PlaneteAdapter PAdapter = new PlaneteAdapter(verifier);
        listview.setAdapter(PAdapter);


        View.OnClickListener verifierListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int score = 0;
                String[] taillePlanete = data.getTaillePlanetes();
                for(int i = 0; i < taillePlanete.length; i++)
                {
                    View v = listview.getChildAt(i);
                    Spinner spinner = (Spinner) v.findViewById(R.id.spinner);

                    TextView textView = v.findViewById(R.id.textView);

                    if (spinner.getSelectedItem().toString().equals(taillePlanete[i]))
                    {
                        score++;
                    }
                }

                Toast.makeText(MainActivity.this,"Vous avez trouvé la taille de : " + score + " planètes sur " +
                        taillePlanete.length, Toast.LENGTH_LONG).show();
            }

        };

        verifier.setOnClickListener(verifierListener);

    }



    public static MainActivity getInstance() {
        return instance;
    }

}


