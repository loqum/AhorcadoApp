package com.example.rfm.ahorcado2;

import android.content.Context;
import android.content.SharedPreferences;
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
    private Button buttonJugar;
    private int contadorErrores;
    private String intento;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelContador = findViewById(R.id.labelContador);
        labelPalabraSecreta = findViewById(R.id.labelPalabraSecreta);
        inputRespuesta = findViewById(R.id.inputRespuesta);
        buttonJugar = findViewById(R.id.buttonJugar);

        palabraSecreta = "asamblea";

//        interrogante = new String(new char[palabraSecreta.length()]).replace("\0", "?");
//        final String[] letra = palabraSecreta.split("");

        labelPalabraSecreta.setText(palabraSecreta.replaceAll("([A-Za-z])", "?"));

        buttonJugar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onResume();

                if (Utils.isValidLetter(inputRespuesta.getText().toString())) {

                    inputRespuesta.setText("");

                    intento = sharedPreferences.getString("intento", "Hola");

                    if (palabraSecreta.contains(inputRespuesta.getText().toString().toLowerCase())) {

                        labelPalabraSecreta.setText(Utils.isCorrectLetter(palabraSecreta, intento));


                    } else {

                        labelPalabraSecreta.setText(Utils.isCorrectLetter(palabraSecreta, intento));

                        labelContador.setText(getString(texto_contador, ++contadorErrores));

                        Toast.makeText(getBaseContext(), "Letra incorrecta", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getBaseContext(), "Debes introducir una letra", Toast.LENGTH_LONG);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();

        sharedPreferences = getSharedPreferences("Intentos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("intento", inputRespuesta.getText().toString());
        editor.apply();
    }

}
