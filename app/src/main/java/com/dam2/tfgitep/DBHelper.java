package com.dam2.tfgitep;
import static java.lang.String.valueOf;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("create Table users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, address TEXT)");
        MyDB.execSQL("INSERT INTO users VALUES(null,'admin','admin','admin');");
        MyDB.execSQL("INSERT INTO users VALUES(null,'a','a','a');");
        MyDB.execSQL("INSERT INTO users VALUES(null,'b','b','b');");

        MyDB.execSQL("create Table lugares (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, location TEXT, country TEXT, city TEXT)");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Puerta de Brandeburgo','https://goo.gl/maps/UhbfYQqCbxx3EqfX7', 'alemania', 'berlin');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Neuschwanstein','https://goo.gl/maps/7iK7NjFzCitB2HnHA', 'alemania', 'munich');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Catedral de Colonia','https://goo.gl/maps/QZckxka3wDBp4dM59', 'alemania', 'colonia');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Opera de Sidney','https://goo.gl/maps/cdA4oKGmwZAZNtBp8', 'australia', 'sidney');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Los Doce Apóstoles','https://goo.gl/maps/BC9hf2YYPUurUFW96', 'australia', 'victoria');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Melbourne','https://goo.gl/maps/UoQAn51aqzDMoSmH6', 'australia', 'victoria');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Torre CN','https://goo.gl/maps/EhP4dKU48PF2aibY7', 'canada', 'toronto');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Parque Nacional Yoho','https://goo.gl/maps/CKUt39pu3XC8NYFv7', 'canada', 'columbia británica');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Edificio del Parlamento de Quebec','https://goo.gl/maps/nCJXr4U3gXNQgPyu6', 'canada', 'quebec');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Muralla China','https://goo.gl/maps/B5JAMoXg4YXDKSs87', 'china', 'pekín');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Templo del Cielo','https://goo.gl/maps/sY49gnsQ9q7Dycsq7', 'china', 'pekín');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Guerreros de terracota','https://goo.gl/maps/gDimhEvN4fiFEwvz9', 'china', 'Shaanxi');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'La Esfinge','https://goo.gl/maps/AVqWy2sa6tJufLkA9', 'egipto', 'el cairo');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Templo de Ramsés II','https://goo.gl/maps/RZWCCyJ1eBjuN3kDA', 'egipto', 'luxor');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Valle de los Reyes','https://goo.gl/maps/ZqQFyrnEjx7baEP7A', 'egipto', 'luxor');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Plaza España','https://goo.gl/maps/NCh51RCNqykKLgfF8', 'españa', 'sevilla');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Teide','https://goo.gl/maps/QaEPNDpYa2FPEzsYA', 'españa', 'tenerife');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Sagrada Familia','https://goo.gl/maps/mnPKMXJ2eVwcZt7L6', 'españa', 'barcelona');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Estatua de la Libertad','https://goo.gl/maps/r3B8C8iWw7TpiuRk6', 'eeuu', 'new york');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Monte Rushmore','https://goo.gl/maps/NYfSwVAK5pqe6Foa6', 'eeuu', 'dakota del sur');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Parque Nacional Yellowstone','https://goo.gl/maps/r1aQB4g6khmJkzyb9', 'eeuu', 'wyoming');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Torre Eiffel','https://goo.gl/maps/5wNoxpRMS3DEo4m38', 'francia', 'paris');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Arco de Triunfo','https://goo.gl/maps/wUf68mgo2razm2W79', 'francia', 'paris');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Catedral de Notre Dame','https://goo.gl/maps/8XFufSNBRvN6KL2p9', 'francia', 'paris');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Taj Mahal','https://goo.gl/maps/xPRGvjjpuujjS7DH8', 'india', 'agra');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Hawa Mahal','https://goo.gl/maps/NwQibukFbojVcZ3G7', 'india', 'jaipur');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Templo Dorado','https://goo.gl/maps/DE1ePXmkDt8ym8gy8', 'india', 'amritsar');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Fushimi Inari-taisha','https://goo.gl/maps/uTwKt8WosnsAshGa8', 'japon', 'kyoto');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Sensō-ji','https://goo.gl/maps/mn5w2veiS6WpmxSs5', 'japon', 'tokyo');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Kinkaku-ji','https://goo.gl/maps/fSqNxochZw78239U8', 'japon', 'kyoto');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Mezquita Hassan II','https://goo.gl/maps/akMKcuXGdSA9Qbgr6', 'marruecos', 'casablanca');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Palacio de la bahía','https://goo.gl/maps/1RMpfrKwQzStP8SN8', 'marruecos', 'marrakesh');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Mezquita Kutubía','https://goo.gl/maps/tD6nWLeM9PVRuW5F7', 'marruecos', 'marrakesh');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Chichén Itzá','https://goo.gl/maps/31sWpX75TbCcPCCD8', 'mexico', 'yucatán');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Palacio de Bellas Artes','https://goo.gl/maps/7F43uwMrLXttomSm8', 'mexico', 'ciudad de méxico');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Zona Arqueológica de Tulum','https://goo.gl/maps/n8o661AK2J5BTjYT7', 'mexico', 'tulum');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Hobbiton™ Movie Set Tours','https://goo.gl/maps/BJox6hrhdX8rSEaw5', 'nueva zelanda', 'matamata');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Milford Sound','https://goo.gl/maps/FzCPKLR4xGyYwesf9', 'nueva zelanda', 'nueva zelanda');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Monte Cook','https://goo.gl/maps/NETL7u2PU3PKf2Jm7', 'nueva zelanda', 'nueva zelanda');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Lago de las Medusas','https://goo.gl/maps/3Lt5vRjMWJEeMMMa7', 'palaos', 'estado de koror');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Islas Chelbacheb','https://goo.gl/maps/AF5t3TtsPuRmFREv6', 'palaos', 'estado de koror');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Belau National Museum','https://goo.gl/maps/7S4FPnEYpJUWxWzj7', 'palaos', 'koror');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Parque nacional Kruger','https://goo.gl/maps/DRgBFqzbo1PGtav17', 'sudafrica', 'sudafrica');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Kirstenbosch National Botanical Garden','https://goo.gl/maps/gDWnXH8wLuvYgH6z8', 'sudafrica', 'ciudad del cabo');");
        MyDB.execSQL("INSERT INTO lugares VALUES(null,'Cabo de Buena Esperanza','https://goo.gl/maps/gam2HAman1SHurJn9', 'sudafrica', 'ciudad del cabo');");

        MyDB.execSQL("create Table hoteles(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, location TEXT, country TEXT, city TEXT)");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Hotel Adlon Kempinski','https://goo.gl/maps/qbF7s64LJ6R1pict7', 'alemania', 'berlin');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Park Hyatt','https://goo.gl/maps/eczL8BBNerTRuxmP7', 'australia', 'sidney');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Banff Springs','https://goo.gl/maps/nGkc4hxMUyiLYfSN6', 'canada', 'alberta');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'The Temple House','https://goo.gl/maps/JD8QqQ53xnThuqZP6', 'china', 'chengdú');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Jaz Aquaviva','https://goo.gl/maps/g5ULtVvZW5ZUHCAd6', 'egipto', 'hurgada');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Finca Cortesin','https://goo.gl/maps/4JBg5b9zidpTGRiw7', 'españa', 'malaga');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'The Little Nell','https://goo.gl/maps/VYKidJXNCXCBrkdF8', 'eeuu', 'colorado');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Hôtel Plaza Athénée','https://goo.gl/maps/MfqtAxquVadWDWiBA', 'francia', 'paris');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Evolve Back, Hampi','https://goo.gl/maps/2fFrrrA1HwgLuSSm6', 'india', 'karnataka');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Aman Tokyo','https://goo.gl/maps/uRuAvNJgSwoeDHQp9', 'japon', 'tokio');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Royal Mansour Marrakech','https://goo.gl/maps/uxfWMmd3yNxqqxR96', 'marruecos', 'marrakech');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Hotel Esencia','https://goo.gl/maps/wSixK6iRFGx8UeHVA', 'mexico', 'Xpu Ha');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Delamore Lodge','https://goo.gl/maps/oAc7TTZoMuXNKjX87', 'nueva zelanda', 'auckland');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Palau pacific resort','https://goo.gl/maps/MCaRAjzrJpL2mbdU9', 'palaos', 'koror');");
        MyDB.execSQL("INSERT INTO hoteles VALUES(null,'Beach Villa Wilderness','https://goo.gl/maps/VKEQjP4VzgDpXTG89', 'sudafrica', 'wilderness');");

        MyDB.execSQL("create Table restaurantes(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, location TEXT, country TEXT, city TEXT)");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Zur Haxe','https://goo.gl/maps/RtUEysnXM1MvEgF26', 'alemania', 'berlin');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Nour Sydney','https://goo.gl/maps/U2Vo1SYWijEXAfLV9', 'australia', 'victoria');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'RASA','https://goo.gl/maps/wQnXSnF1yqwaW85f6', 'canada', 'toronto');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Black Sesame Kitchen','https://goo.gl/maps/RSNTnYrz61BvCLR49', 'china', 'pekín');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Zitouni','https://goo.gl/maps/FWAp9jF5czym87xT9', 'egipto', 'el cairo');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Tickets bar','https://goo.gl/maps/dAV6arQQhe1VKMbW6', 'españa', 'barcelona');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Saison','https://goo.gl/maps/9spEdKk4MYfc3E8x5', 'eeuu', 'san francisco');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Il était un square','https://goo.gl/maps/KL2eHFLWLJa8zckU9', 'francia', 'parís');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Mosaic','https://goo.gl/maps/GqL2qjWtWWYPuxv26', 'india', 'radisson jaipur city');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Hajime','https://goo.gl/maps/a7zhFm1jxeWwLzY66', 'japon', 'tokyo');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'POKA','https://goo.gl/maps/GVhUSJiXsqnjJpNB6', 'marruecos', 'marrakesh');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Condimento Restaurant','https://goo.gl/maps/AhLsnig3see5kgtu5', 'mexico', 'ciudad de méxico');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Burger Commercial Bay','https://goo.gl/maps/WKGDUD2X7zt8z9vP8', 'nueva zelanda', 'auckland');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'The Taj','https://goo.gl/maps/sb5fvhryLPnwFwvAA', 'palaos', 'koror');");
        MyDB.execSQL("INSERT INTO restaurantes VALUES(null,'Mozambik Linksfield','https://goo.gl/maps/zQAZmThHpkEJxhtx8', 'sudafrica', 'johannesburgo');");
    }

//Estos gets son para guardar la variable String de cada pais para mostrar en el recycler view

    public Cursor getdataLugares(String country){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from lugares where country = ?", new String[]{country});
        return cursor;
    }

    public Cursor getdataHoteles(String country){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from hoteles where country = ?", new String[]{country});
        return cursor;
    }

    public Cursor getdataRestaurantes(String country){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from restaurantes where country = ?", new String[]{country});
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("drop Table users");
        MyDB.execSQL("drop Table lugares");
        MyDB.execSQL("drop Table hoteles");
        MyDB.execSQL("drop Table restaurantes");
        onCreate(MyDB);
    }


    public Boolean insertData(String username, String password, String address){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);

        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertDataHotel(String name, String location, String country, String city){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("location", location);
        contentValues.put("country", country);
        contentValues.put("city", city);

        long result = MyDB.insert("hoteles", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertDataLugar(String name, String location, String country, String city){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("location", location);
        contentValues.put("country", country);
        contentValues.put("city", city);

        long result = MyDB.insert("lugares", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertDataRestaurante(String name, String location, String country, String city){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("location", location);
        contentValues.put("country", country);
        contentValues.put("city", city);

        long result = MyDB.insert("restaurantes", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }


    public Boolean checkuseraddress(String address) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where address = ?", new String[]{address});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String address, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where address = ? and password = ?", new String[] {address,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checknamelugar(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from lugares where name = ?", new String[]{name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checknamehotel(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from hoteles where name = ?", new String[]{name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checknamerestaurante(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from restaurantes where name = ?", new String[]{name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    public Boolean updateuserdata(String username, String password, String address)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        Cursor cursor = MyDB.rawQuery("Select * from users where address = ?", new String[]{address});
        if (cursor.getCount() > 0) {
            long result = MyDB.update("users", contentValues, "address=?", new String[]{address});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deletedata (String address)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where address = ?", new String[]{address});
        if (cursor.getCount() > 0) {
            long result = MyDB.delete("users", "address=?", new String[]{address});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedatalugar (String name)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from lugares where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = MyDB.delete("lugares", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedatahotel (String name)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from hoteles where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = MyDB.delete("hoteles", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedatarestaurante (String name)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from restaurantes where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = MyDB.delete("restaurantes", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    //Estos gets son para hacer el view en un alert dialog en los apartados de gestion

    public Cursor getdata ()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users", null);
        return cursor;
    }

    public Cursor getdatalugar ()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from lugares", null);
        return cursor;
    }

    public Cursor getdatahotel ()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from hoteles", null);
        return cursor;
    }

    public Cursor getdatarestaurante ()
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from restaurantes", null);
        return cursor;
    }


    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private Context context;
        private ArrayList nombre_id, ubicacion_id, pais_id, ciudad_id;


        public MyAdapter(Context context, ArrayList nombre_id, ArrayList ubicacion_id, ArrayList pais_id, ArrayList ciudad_id) {
            this.context = context;
            this.nombre_id = nombre_id;
            this.ubicacion_id = ubicacion_id;
            this.pais_id = pais_id;
            this.ciudad_id = ciudad_id;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nombre_id.setText(valueOf(nombre_id.get(position)));
            holder.ubicacion_id.setText(valueOf(ubicacion_id.get(position)));
            holder.pais_id.setText(valueOf(pais_id.get(position)));
            holder.ciudad_id.setText(valueOf(ciudad_id.get(position)));
        }

        @Override
        public int getItemCount() {
            return nombre_id.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {


            TextView nombre_id, ubicacion_id, pais_id, ciudad_id;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                nombre_id = itemView.findViewById(R.id.textnombre);
                ubicacion_id = itemView.findViewById(R.id.textubicacion);
                pais_id = itemView.findViewById(R.id.textpais);
                ciudad_id = itemView.findViewById(R.id.textciudad);
                itemView.findViewById(R.id.linkmap).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent linksmaps = new Intent(Intent.ACTION_VIEW,Uri.parse(String.valueOf(ubicacion_id.getText())));
                        context.startActivity(linksmaps);
                    }
                });
            }
        }
    }
}
