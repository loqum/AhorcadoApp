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
        final TextView labelPalabraSecreta = (TextView) findViewById(R.id.labelPalabraSecreta);
        final EditText inputRespuesta = (EditText) findViewById(R.id.inputRespuesta);

        final String palabraSecreta = "Arbol";
        final String interrogante = new String(new char[palabraSecreta.length()]).replace("\0", "?");

        final String[] letra = palabraSecreta.split("");

        labelPalabraSecreta.setText(palabraSecreta.replaceAll("([A-Z,a-z])", "?"));

        buttonIntentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 1; i < letra.length; i ++) {
                    if (letra[i].equalsIgnoreCase(inputRespuesta.getText().toString())) {
                        labelPalabraSecreta.setText(letra[i].concat(new String(new char[palabraSecreta.length() - i]).replace("\0", "?")));
                    } else {
                        labelPalabraSecreta.setText(interrogante);
                    }
                }

            }
        });
    }
}
