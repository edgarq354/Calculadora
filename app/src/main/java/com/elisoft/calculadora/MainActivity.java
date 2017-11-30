package com.elisoft.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    Button bt_suma,bt_resta, bt_mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_suma=(Button)findViewById(R.id.bt_suma);
        bt_resta=(Button)findViewById(R.id.bt_resta);
        bt_mensaje=(Button)findViewById(R.id.bt_mensaje);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bt_suma.setOnClickListener(this);
        bt_resta.setOnClickListener(this);
        bt_mensaje.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_suma:
                startActivity(new Intent(this, Suma.class));
                break;
            case R.id.bt_resta:
                startActivity(new Intent(this, Resta.class));
                break;
            case R.id.bt_mensaje:
                Intent intent= new Intent(this, Mensaje_hilo.class);
                intent.putExtra("mensaje",bt_mensaje.getText().toString());
                startActivity(intent);
                break;
        }
    }
}
