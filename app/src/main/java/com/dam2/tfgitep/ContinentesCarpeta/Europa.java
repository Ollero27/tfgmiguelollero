package com.dam2.tfgitep.ContinentesCarpeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.dam2.tfgitep.LoginActivity;
import com.dam2.tfgitep.Paises.Alemania;
import com.dam2.tfgitep.Paises.Espania;
import com.dam2.tfgitep.Paises.Francia;
import com.dam2.tfgitep.R;

public class Europa extends AppCompatActivity {


    LinearLayout LinearLayout;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_europa);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        LinearLayout app_layer = (LinearLayout) findViewById (R.id.buttonEspania);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEspania=new Intent(Europa.this, Espania.class);
                startActivity(intentEspania);
            }
        });

        LinearLayout app_layer2 = (LinearLayout) findViewById (R.id.buttonAlemania);
        app_layer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAlemania=new Intent(Europa.this, Alemania.class);
                startActivity(intentAlemania);
            }
        });

        LinearLayout app_layer3 = (LinearLayout) findViewById (R.id.buttonFrancia);
        app_layer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFrancia=new Intent(Europa.this, Francia.class);
                startActivity(intentFrancia);
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