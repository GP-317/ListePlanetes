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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    ListView listview;
    PlaneteAdapter adapter;
    Button verifier = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifier = (Button)findViewById(R.id.btnVerify);

        instance = this;

        listview = (ListView) findViewById(R.id.listView);
        //adapter = new PlaneteAdapter();

        PlaneteAdapter PAdapter = new PlaneteAdapter(verifier);
        listview.setAdapter(PAdapter);


    }

    public static MainActivity getInstance() {
        return instance;
    }

}


