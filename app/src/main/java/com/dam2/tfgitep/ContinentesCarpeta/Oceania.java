package com.dam2.tfgitep.ContinentesCarpeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dam2.tfgitep.LoginActivity;
import com.dam2.tfgitep.Paises.Alemania;
import com.dam2.tfgitep.Paises.Australia;
import com.dam2.tfgitep.Paises.Espania;
import com.dam2.tfgitep.Paises.Francia;
import com.dam2.tfgitep.Paises.NuevaZelanda;
import com.dam2.tfgitep.Paises.Palaos;
import com.dam2.tfgitep.R;

public class Oceania extends AppCompatActivity {

    LinearLayout LinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oceania);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);




        LinearLayout app_layer = (LinearLayout) findViewById (R.id.buttonAustralia);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAustralia=new Intent(Oceania.this, Australia.class);
                startActivity(intentAustralia);
            }
        });

        LinearLayout app_layer2 = (LinearLayout) findViewById (R.id.buttonNuevaZelanda);
        app_layer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNuevaZelanda=new Intent(Oceania.this, NuevaZelanda.class);
                startActivity(intentNuevaZelanda);
            }
        });

        LinearLayout app_layer3 = (LinearLayout) findViewById (R.id.buttonPalaos);
        app_layer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPalaos=new Intent(Oceania.this, Palaos.class);
                startActivity(intentPalaos);
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
