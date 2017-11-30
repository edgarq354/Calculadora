package com.elisoft.calculadora;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mensaje_hilo extends AppCompatActivity {

    TextView tv_mensaje,tv_numero;
    int i;
    Handler handle=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_hilo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tv_mensaje=(TextView)findViewById(R.id.tv_mensaje);
        tv_numero=(TextView)findViewById(R.id.tv_numero);

        try{
            Bundle bundle= getIntent().getExtras();
            tv_mensaje.setText(bundle.getString("mensaje"));

            i=0;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (i<25)
                    {
                        i=i+1;
                        handle.post(new Runnable() {
                            @Override
                            public void run() {
                                tv_numero.setText(String.valueOf(i));
                            }
                        });


                        try{
                            Thread.sleep(2000);
                        }catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }catch (Exception e){

        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
