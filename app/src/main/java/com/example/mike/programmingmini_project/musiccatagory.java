package com.example.mike.programmingmini_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class musiccatagory extends AppCompatActivity {

    TextView textView;
public Button musicbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiccatagory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.musicquestion);

        textView.setMovementMethod(new ScrollingMovementMethod());


        String data = "";

        Random r = new Random();
        int index = (r.nextInt(6 - 1) + 1);//(r.nextInt( (to+1) - (from) ) + (from)  );

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {

            builder = factory.newDocumentBuilder();
            InputStream istr = this.getAssets().open("CAT.xml");
            Document doc = builder.parse(istr);
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//CATEGORIES//MUSIC//M" + String.valueOf(index));
            data = expr.evaluate(doc, XPathConstants.STRING).toString();
            textView.setText(data);

        } catch (Exception e) {
            textView.setText(e.getMessage());

        }
    }

    public void musicnext() {
        musicbtn =(Button) findViewById(R.id.musicbtn);
        musicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musicnext = new Intent(musiccatagory.this,musiccatagory.class);

                startActivity(musicnext);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage, menu);

        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
            musicnext();

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
        switch (id) {

            case R.id.action_settings:
                Intent settings = new Intent(musiccatagory.this, Settings.class);
                startActivity(settings);
                break;

            case R.id.action_info:

                Intent information = new Intent(musiccatagory.this, Infopage.class);

                startActivity(information);
                break;
            case R.id.action_homepage:
                Intent homebutton = new Intent(musiccatagory.this,Homepage.class);
                startActivity(homebutton);
                break;
        }
    return super.onOptionsItemSelected(item);
    }
}
