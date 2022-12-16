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
import com.dam2.tfgitep.Paises.Egipto;
import com.dam2.tfgitep.Paises.Espania;
import com.dam2.tfgitep.Paises.Francia;
import com.dam2.tfgitep.Paises.Marruecos;
import com.dam2.tfgitep.Paises.Sudafrica;
import com.dam2.tfgitep.R;

public class Africa extends AppCompatActivity {

    android.widget.LinearLayout LinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africa);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);



        LinearLayout app_layer = (LinearLayout) findViewById (R.id.buttonSudafrica);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSudafrica=new Intent(Africa.this, Sudafrica.class);
                startActivity(intentSudafrica);
            }
        });

        LinearLayout app_layer2 = (LinearLayout) findViewById (R.id.buttonEgipto);
        app_layer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEgipto=new Intent(Africa.this, Egipto.class);
                startActivity(intentEgipto);
            }
        });

        LinearLayout app_layer3 = (LinearLayout) findViewById (R.id.buttonMarruecos);
        app_layer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMarruecos=new Intent(Africa.this, Marruecos.class);
                startActivity(intentMarruecos);
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