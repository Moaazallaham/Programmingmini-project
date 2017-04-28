package com.example.mike.programmingmini_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    public Button but1, but2, but3, but4, but5, but6, but7, but8, but9;

    public void category1() {
        but1 =(Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category1 = new Intent(Homepage.this,musiccatagory.class);

                startActivity(category1);
            }
        });
    }

    public void category2() {
        but2 =(Button) findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category2 = new Intent(Homepage.this,animalcategory.class);

                startActivity(category2);
            }
        });
    }
    public void category3() {
        but3 = (Button)findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category3 = new Intent(Homepage.this,naturecatagory.class);

                startActivity(category3);
            }
        });
    }
    public void category4() {
        but4 = (Button) findViewById(R.id.but4);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category4 = new Intent(Homepage.this,spacecatagory.class);

                startActivity(category4);
            }
        });
    }
    public void category5() {
        but4 = (Button) findViewById(R.id.but5);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category5 = new Intent(Homepage.this,filmcatagory.class);

                startActivity(category5);
            }
        });
    }
    public void category6() {
        but4 = (Button) findViewById(R.id.but6);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category6 = new Intent(Homepage.this,randomcatagory.class);

                startActivity(category6);
            }
        });
    }
    public void category7() {
        but7 = (Button)findViewById(R.id.but7);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category7 = new Intent(Homepage.this,foodcategory.class);

                startActivity(category7);
            }
        });
    }
    public void category8() {
        but7 = (Button)findViewById(R.id.but8);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category8 = new Intent(Homepage.this,famouscategory.class);

                startActivity(category8);
            }
        });
    }
    public void category9() {
        but7 = (Button)findViewById(R.id.but9);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category9 = new Intent(Homepage.this,sportcategory.class);

                startActivity(category9);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        category1();
        category2();
        category3();
        category4();
        category5();
        category6();
        category7();
        category8();
        category9();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage, menu);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){

            case R.id.action_settings:
                Intent settings = new Intent(Homepage.this,Settings.class);
                startActivity(settings);
                break;

            case R.id.action_info:

                Intent information = new Intent(Homepage.this,Infopage.class);
                Toast.makeText(getApplicationContext(),"Moaaz is a noob", Toast.LENGTH_SHORT).show();

                startActivity(information);
                break;
            case R.id.action_homepage:
                Intent homebutton = new Intent(Homepage.this,Homepage.class);
                startActivity(homebutton);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
