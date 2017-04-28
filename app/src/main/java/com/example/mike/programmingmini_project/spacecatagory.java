package com.example.mike.programmingmini_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;

import java.io.InputStream;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class spacecatagory extends AppCompatActivity {

    TextView textView;
    public Button spacebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spacecatagory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.spacequestion);

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
            XPathExpression expr = xpath.compile("//CATEGORIES//SPACE//M" + String.valueOf(index));
            data = expr.evaluate(doc, XPathConstants.STRING).toString();
            textView.setText(data);

        } catch (Exception e) {
            textView.setText(e.getMessage());

        }

    }
    public void spacenext() {
        spacebtn =(Button) findViewById(R.id.spacebtn);
        spacebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spacenext = new Intent(spacecatagory.this,spacecatagory.class);

                startActivity(spacenext);
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
            spacenext();


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
                Intent settings = new Intent(spacecatagory.this, Settings.class);
                startActivity(settings);
                break;

            case R.id.action_info:

                Intent information = new Intent(spacecatagory.this, Infopage.class);

                startActivity(information);
                break;
            case R.id.action_homepage:
                Intent homebutton = new Intent(spacecatagory.this,Homepage.class);
                startActivity(homebutton);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
