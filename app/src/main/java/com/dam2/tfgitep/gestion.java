package com.dam2.tfgitep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gestion extends AppCompatActivity {

    EditText username, password, address;
    Button update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById (R.id.btnAddLugar);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLugar=new Intent(gestion.this, gestionlugar.class);
                startActivity(intentLugar);
            }
        });

        Button button2 = (Button) findViewById (R.id.btnAddHotel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHotel=new Intent(gestion.this, gestionhotel.class);
                startActivity(intentHotel);
            }
        });

        Button button3 = (Button) findViewById (R.id.btnAddRestaurante);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRestaurante=new Intent(gestion.this, gestionrestaurante.class);
                startActivity(intentRestaurante);
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = DB.getdata();
                String addr = address.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")||addr.equals("")){
                    Toast.makeText(gestion.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (address.getText().toString().equals("admin")) {
                    Toast.makeText(gestion.this, "No se puede cambiar el usuario y contraseña del admin", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    Boolean checkupdatedata = DB.updateuserdata(username.getText().toString(), password.getText().toString(), address.getText().toString());
                    if (checkupdatedata == true)
                        Toast.makeText(gestion.this, "Entrada actualizada", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(gestion.this, "Nueva entrada no actualizada", Toast.LENGTH_SHORT).show();
                }
            }

        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addr = address.getText().toString();
                if (address.getText().toString().equals("admin")) {
                    Toast.makeText(gestion.this, "No se puede borrar el usuario admin", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    Boolean checkudeletedata = DB.deletedata(addr);
                    if (checkudeletedata == true)
                        Toast.makeText(gestion.this, "Entrada borrada", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(gestion.this, "Entrada no borrada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = DB.getdata();
                if (cursor.getCount() == 0) {
                    Toast.makeText(gestion.this, "No existe ninguna entrada", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("Email : " + cursor.getString(3) + "\n");
                    buffer.append("Usuario : " + cursor.getString(1) + "\n");
                    buffer.append("Contraseña : " + cursor.getString(2) + "\n");
                    buffer.append("\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(gestion.this);
                builder.setCancelable(true);
                builder.setTitle("Lista de usuarios");
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



