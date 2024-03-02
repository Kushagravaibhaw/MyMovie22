package com.example.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tr = findViewById(R.id.tr);
        Button pm = findViewById(R.id.pm);

        db=openOrCreateDatabase("Movie DB",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE if not exists Movies(movie_id int primary key,movie_name varchar(50),rating int,movie_cast varchar(100),language varchar(20),year int)");
        Cursor cursor = db.rawQuery("select * from Movies ",null);
        if(cursor.getCount()==0){

            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (1, 'Dilwale Dulhania Le Jayenge', 8.1, 'Shah Rukh Khan', 'Hindi', 1995)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (2, '3 Idiots', 8.4, 'Aamir Khan', 'Hindi', 2009)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (3, 'Lagaan', 8.1, 'Aamir Khan', 'Hindi', 2001)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (4, 'Dangal', 8.4, 'Aamir Khan', 'Hindi', 2016)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (5, 'Bajrangi Bhaijaan', 8.0, 'Salman Khan', 'Hindi', 2015)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (6, 'Padmaavat', 7.0, 'Deepika Padukone', 'Hindi', 2018)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (7, 'PK', 8.1, 'Aamir Khan', 'Hindi', 2014)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (8, 'Sultan', 7.0, 'Salman Khan', 'Hindi', 2016)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (9, 'Chennai Express', 6.0, 'Shah Rukh Khan', 'Hindi', 2013)");
            db.execSQL("INSERT INTO Movies (movie_id, movie_name, rating, movie_cast, language, year)VALUES (10, 'Raees', 6.8, 'Shah Rukh Khan', 'Hindi', 2017)");
        }


        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TopRated.class);
                startActivity(intent);
            }
        });

        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PopularMovies.class);
                startActivity(intent);
            }
        });




    }
}