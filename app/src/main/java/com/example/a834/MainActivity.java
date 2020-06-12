package com.example.a834;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

class project {
    public String name;
    public String description;
    public String technos;
    public String devs;

    public project(String name, String description, String technos, String devs){
        this.name = name;
        this.description = description;
        this.technos = technos;
        this.devs = devs;
    }
}

public class MainActivity extends AppCompatActivity {


    ArrayAdapter<project> projects;
    ListView projectList = (ListView) findViewById(R.id.list);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public EditText username = (EditText)findViewById(R.id.editText1);
    public EditText password = (EditText)findViewById(R.id.editText2);

    public void login(View view) {
        if (username.getText().toString().equals("leader") && password.getText().toString().equals("leader")) {
            //Navigation vers la page home (leaders) par exemple
            setContentView(R.layout.fragment_home);
        } else if (username.getText().toString().equals("dev") && password.getText().toString().equals("dev")) {
            //Navigation vers la page home (leaders) par exemple
            setContentView(R.layout.fragment_notifications);
        } else {
            //Erreur sur un label
        }
    }

    public EditText name = (EditText)findViewById(R.id.editTextTextPersonName);
    public EditText desc = (EditText)findViewById(R.id.editTextTextPersonName2);
    public EditText tech = (EditText)findViewById(R.id.editTextTextPersonName3);

    public void submit(View view) {
        project tempProj = new project(name.getText().toString(), desc.getText().toString(), tech.getText().toString(), "");
        updt();
    }

    public void updt(){
        //Erreur ici ???
        projectList.setText(projects);
    }

}