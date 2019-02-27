package com.example.rfm.ahorcado2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIntentar = (Button) findViewById(R.id.buttonJugar);
        final TextView textPalabra = (TextView) findViewById(R.id.labelPalabraSecreta);
        final EditText textInput = (EditText) findViewById(R.id.inputRespuesta);

        String palabraSecreta = "Arbol";

        final String[] letra = palabraSecreta.split("");


        buttonIntentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.isCorrectLetter(textInput.getText().toString(), letra[0])) {
                    textPalabra.setText("Correcto");
                } else {
                    textPalabra.setText("Incorrecto");
                }
            }
        });
    }
}
