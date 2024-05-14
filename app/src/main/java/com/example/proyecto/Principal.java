package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Código de la actividad Principal (Principal.java)

public class Principal extends AppCompatActivity {

    private Button BotonAcerca;
    Button BotonSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BotonAcerca = findViewById(R.id.btnAcercaPrin);
        BotonAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad AcercaDe cuando se haga clic en el botón "Acerca de"
                Intent intent = new Intent(Principal.this, Acercade.class);
                startActivity(intent);
            }
        });


        BotonSalir = findViewById(R.id.btnSalirPrinc);
        BotonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad AcercaDe cuando se haga clic en el botón "Acerca de"
                Intent intent = new Intent(Principal.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}



