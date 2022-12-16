package com.dam2.tfgitep.Paises;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.dam2.tfgitep.DBHelper;

import com.dam2.tfgitep.Hoteles.Hotel;
import com.dam2.tfgitep.LoginActivity;
import com.dam2.tfgitep.Lugares.Lugar;
import com.dam2.tfgitep.R;

import com.dam2.tfgitep.Restaurantes.Restaurante;

public class Egipto extends AppCompatActivity {

    DBHelper DB;
    String paisdato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DB = new DBHelper(this);



        LinearLayout LinearLayout;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egipto);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayout app_layer = (LinearLayout) findViewById (R.id.buttonLugares);
        LinearLayout app_layer2 = (LinearLayout) findViewById (R.id.buttonhoteles);
        LinearLayout app_layer3 = (LinearLayout) findViewById (R.id.buttonRestaurantes);

        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paisdato = "egipto";
                Intent intentLugar=new Intent(Egipto.this, Lugar.class);
                intentLugar.putExtra("datopais", paisdato);
                startActivity(intentLugar);
            }

        });

        app_layer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paisdato = "egipto";
                Intent intentLugar=new Intent(Egipto.this, Hotel.class);
                intentLugar.putExtra("datopais", paisdato);
                startActivity(intentLugar);
            }

        });

        app_layer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paisdato = "egipto";
                Intent intentLugar=new Intent(Egipto.this, Restaurante.class);
                intentLugar.putExtra("datopais", paisdato);
                startActivity(intentLugar);
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