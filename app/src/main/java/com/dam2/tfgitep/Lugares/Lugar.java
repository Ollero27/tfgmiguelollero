package com.dam2.tfgitep.Lugares;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dam2.tfgitep.DBHelper;
import com.dam2.tfgitep.LoginActivity;
import com.dam2.tfgitep.R;

import java.util.ArrayList;


public class Lugar extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> nombre, ubicacion, pais, map, ciudad;
    DBHelper DB;
    DBHelper.MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        DB = new DBHelper(this);


        nombre = new ArrayList<>();
        ubicacion = new ArrayList<>();
        pais = new ArrayList<>();
        map = new ArrayList<>();
        ciudad = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new DBHelper.MyAdapter(this,nombre, ubicacion, pais, ciudad);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }



    private void displaydata() {

        String paisdato = getIntent().getStringExtra("datopais");

        Cursor cursor = DB.getdataLugares(paisdato);

        if(cursor.getCount()==0){
            Toast.makeText(Lugar.this, " No hay entradas", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while(cursor.moveToNext()){
                nombre.add(cursor.getString(1));
                ubicacion.add(cursor.getString(2));
                pais.add(cursor.getString(3));
                ciudad.add(cursor.getString(4));
            }
        }
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