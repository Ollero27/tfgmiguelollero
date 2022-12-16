package com.dam2.tfgitep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dam2.tfgitep.ContinentesCarpeta.Africa;
import com.dam2.tfgitep.ContinentesCarpeta.America;
import com.dam2.tfgitep.ContinentesCarpeta.Asia;
import com.dam2.tfgitep.ContinentesCarpeta.Europa;
import com.dam2.tfgitep.ContinentesCarpeta.Oceania;


public class Continentes extends AppCompatActivity {


    Button EuropaBtn;
    Button AsiaBtn;
    Button AmericaBtn;
    Button AfricaBtn;
    Button OceaniaBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continentes);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        EuropaBtn=(Button)findViewById(R.id.buttonEu);
        AsiaBtn=(Button)findViewById(R.id.buttonAs);
        AmericaBtn=(Button)findViewById(R.id.buttonAm);
        AfricaBtn=(Button)findViewById(R.id.buttonAf);
        OceaniaBtn=(Button)findViewById(R.id.buttonOc);


        EuropaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEuropa=new Intent(Continentes.this, Europa.class);
                startActivity(intentEuropa);
            }
        });
        AsiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAsia=new Intent(Continentes.this, Asia.class);
                startActivity(intentAsia);
            }
        });
        AmericaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAmerica=new Intent(Continentes.this, America.class);
                startActivity(intentAmerica);
            }
        });
        AfricaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAfrica=new Intent(Continentes.this, Africa.class);
                startActivity(intentAfrica);
            }
        });
        OceaniaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOceania=new Intent(Continentes.this, Oceania.class);
                startActivity(intentOceania);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                logOut();
                return true;
            case android.R.id.home:
                this.finish();
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    private void logOut (){
        Intent intent = new Intent (this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }



}