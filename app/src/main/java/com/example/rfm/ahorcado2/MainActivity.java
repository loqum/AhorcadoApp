package com.example.rfm.ahorcado2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.rfm.ahorcado2.R.string.texto_contador;

public class MainActivity extends AppCompatActivity {

    private TextView labelPalabraSecreta;
    private TextView labelContador;
    private EditText inputRespuesta;
    private String palabraSecreta;
    private int contadorErrores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelContador = findViewById(R.id.labelContador);
        labelPalabraSecreta = findViewById(R.id.labelPalabraSecreta);
        inputRespuesta = findViewById(R.id.inputRespuesta);

        palabraSecreta = "asamblea";

//        interrogante = new String(new char[palabraSecreta.length()]).replace("\0", "?");
//        final String[] letra = palabraSecreta.split("");

        labelPalabraSecreta.setText(palabraSecreta.replaceAll("([A-Za-z])", "?"));

    }

    public void onClickIntentar(View view) {

        if (Utils.isValidLetter(inputRespuesta.getText().toString())) {

            if (palabraSecreta.contains(inputRespuesta.getText().toString().toLowerCase())) {

                labelPalabraSecreta.setText(palabraSecreta.replaceAll("[^" + inputRespuesta.getText().toString().toLowerCase() + "]", "?"));
                inputRespuesta.setText("");

            } else {

                labelPalabraSecreta.setText(palabraSecreta.replaceAll("([A-Za-z])", "?"));
                labelContador.setText(getString(texto_contador, ++contadorErrores));
                Toast.makeText(getBaseContext(), "Letra incorrecta", Toast.LENGTH_SHORT).show();
                inputRespuesta.setText("");

            }
        } else {
            Toast.makeText(getBaseContext(), "Debes introducir una letra", Toast.LENGTH_LONG);
        }
    }
}
