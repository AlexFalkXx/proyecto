package com.example.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Acercade extends AppCompatActivity {
    Button BotonVolver;

    private Button BotMail;
    private Button botonLlamada;
    private String correo = "AlexFallen55_55@hotmail.com";
    private String asunto = "TextoPRUEBA";
    private String contenido = "TextoPrueba";
    private String numeroTelefono = "+1234567890"; // Cambia este número por el número de teléfono deseado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acercade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BotonVolver = findViewById(R.id.btnVolverAcer);
        BotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Acercade.this, Principal.class);
                startActivity(intent);
            }
        });

        // Configurar el OnClickListener para el botón de correo electrónico
        configurarBotonMail();
        // Configurar el OnClickListener para el botón de llamada telefónica
        configurarBotonLlamada();
    }

    private void configurarBotonMail() {
        BotMail = findViewById(R.id.btnMailAcer);
        BotMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("message/rfc822");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{correo});
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                mailIntent.putExtra(Intent.EXTRA_TEXT, contenido);

                // Iniciar la actividad para enviar el correo electrónico
                startActivity(Intent.createChooser(mailIntent, "Selecciona una aplicación de correo electrónico"));
            }
        });
    }

    private void configurarBotonLlamada() {
        botonLlamada = findViewById(R.id.btnLlamadaAcer);
        botonLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear el Intent para realizar la llamada telefónica
                Intent llamadaIntent = new Intent(Intent.ACTION_DIAL);
                llamadaIntent.setData(Uri.parse("tel:" + numeroTelefono));

                // Iniciar la actividad para realizar la llamada telefónica
                startActivity(llamadaIntent);
            }
        });
    }
}
