package com.elisoft.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resta extends AppCompatActivity implements View.OnClickListener {
    EditText et_numero1,et_numero2;
    TextView tv_resultado;
    Button bt_resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resta);

        bt_resolver=(Button)findViewById(R.id.bt_resolver);
        et_numero1=(EditText)findViewById(R.id.et_numero1);
        et_numero2=(EditText)findViewById(R.id.et_numero2);
        tv_resultado=(TextView) findViewById(R.id.tv_resultado);


        bt_resolver.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        if(R.id.bt_resolver==v.getId()){
            int n1=0;
            int n2=0;
            int resul=0;
            try{
                n1=Integer.parseInt(et_numero1.getText().toString());
                n2=Integer.parseInt(et_numero2.getText().toString());

                resul=n1+n2;
                tv_resultado.setText(String.valueOf(resul));
            }catch (Exception e){

                tv_resultado.setText("Por favor ingreso numeros");
            }

        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
