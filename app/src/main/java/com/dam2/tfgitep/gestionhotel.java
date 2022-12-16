package com.dam2.tfgitep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gestionhotel extends AppCompatActivity {

    EditText name, location, country, city ;
    Button update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionhotel);

        name = findViewById(R.id.name);
        location = findViewById(R.id.location);
        country = findViewById(R.id.country);
        city = findViewById(R.id.city);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = DB.getdata();
                String nam = name.getText().toString();
                String loc = location.getText().toString();
                String countri = country.getText().toString();
                String citi = city.getText().toString();

                Boolean checknombrehotel = DB.checknamehotel(nam);

                if (nam.equals("") || loc.equals("") || countri.equals("") || citi.equals("")) {
                    Toast.makeText(gestionhotel.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if(loc.contains("https://goo.gl/maps/")){
                        if (checknombrehotel == false) {
                            Boolean insert = DB.insertDataHotel(nam, loc, countri, citi);
                            if (insert == true) {
                                Toast.makeText(gestionhotel.this, "Entrada registrada", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(gestionhotel.this, "Nueva entrada no registrada", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(gestionhotel.this, "Ya se ha registrado anteriormente", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(gestionhotel.this, "La url no es correcta", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nam = name.getText().toString();

                if(nam.equals("")){
                    Toast.makeText(gestionhotel.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Boolean checkudeletedata = DB.deletedatahotel(nam);
                    if (checkudeletedata == true)
                        Toast.makeText(gestionhotel.this, "Entrada borrada", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(gestionhotel.this, "Entrada no borrada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = DB.getdatahotel();
                if (cursor.getCount() == 0) {
                    Toast.makeText(gestionhotel.this, "No existe ninguna entrada", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("Nombre : " + cursor.getString(1) + "\n");
                    buffer.append("ubicacion : " + cursor.getString(2) + "\n");
                    buffer.append("Pais : " + cursor.getString(3) + "\n");
                    buffer.append("Ciudad : " + cursor.getString(4) + "\n");
                    buffer.append("\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(gestionhotel.this);
                builder.setCancelable(true);
                builder.setTitle("Lista de hoteles");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
