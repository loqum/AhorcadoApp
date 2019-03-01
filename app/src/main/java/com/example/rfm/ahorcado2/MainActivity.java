package com.example.rfm.ahorcado2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.rfm.ahorcado2.R.string.texto_contador;

public class MainActivity extends AppCompatActivity {

    private TextView labelPalabraSecreta;
    private TextView labelContador;
    private EditText inputRespuesta;
    private String palabraSecreta;
    private String interrogante;
    private int contadorErrores = 0;
    private boolean isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIntentar = findViewById(R.id.buttonJugar);
        labelPalabraSecreta = findViewById(R.id.labelPalabraSecreta);
        labelContador = findViewById(R.id.labelContador);
        inputRespuesta = findViewById(R.id.inputRespuesta);

        palabraSecreta = "asamblea";
        interrogante = new String(new char[palabraSecreta.length()]).replace("\0", "?");

        final String[] letra = palabraSecreta.split("");

        labelPalabraSecreta.setText(palabraSecreta.replaceAll("([A-Za-z])", "?"));

        buttonIntentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.isValidLetter(inputRespuesta.getText().toString()) && inputRespuesta.getText().toString() != null) {

                    if (palabraSecreta.contains(inputRespuesta.getText().toString().toLowerCase())) {

                        isCorrect = true;
                        labelPalabraSecreta.setText(palabraSecreta.replaceAll("[^" + inputRespuesta.getText().toString().toLowerCase() + "]", "?"));
                        inputRespuesta.setText("");

                    } else {

                        isCorrect = false;
                        labelPalabraSecreta.setText(palabraSecreta.replaceAll("([A-Za-z])", "?"));
                        labelContador.setText(getString(texto_contador, ++contadorErrores));
                        Toast.makeText(getBaseContext(), "Letra incorrecta", Toast.LENGTH_SHORT).show();
                        inputRespuesta.setText("");

                    }
                } else {
                    Toast.makeText(getBaseContext(), "Debes introducir una letra", Toast.LENGTH_LONG);
                }

            }
        });

    }
}
