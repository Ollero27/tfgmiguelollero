package com.dam2.tfgitep;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword, address;
    Button signup, signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_TFGITEP);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        address = (EditText) findViewById(R.id.address);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);


//REGISTRO

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String addr = address.getText().toString();
                String repass = repassword.getText().toString();


                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuseraddr = DB.checkuseraddress(addr);
                        if(user.equals("admin")||pass.equals("admin")||addr.equals("admin")){
                            Toast.makeText(MainActivity.this, "No te puedes registar como usuario admin", Toast.LENGTH_SHORT).show();
                        }
                        if(checkuseraddr==false){
                            Boolean insert = DB.insertData(user, pass, addr);
                            if(insert==true){

                                Toast.makeText(MainActivity.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Continentes.class);
                                startActivity(intent);


                            }else{
                                Toast.makeText(MainActivity.this, "El registro ha fallado", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "El correo ya existe! por favor, logueate con tu correo", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Las contraseñas no concuerdan", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });



    }



}