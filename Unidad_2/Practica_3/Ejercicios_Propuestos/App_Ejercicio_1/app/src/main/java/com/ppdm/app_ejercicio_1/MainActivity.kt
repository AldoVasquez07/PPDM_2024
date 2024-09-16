package com.ppdm.app_ejercicio_1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Declarando Atributos
    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Realizando búsqueda de los componentes XML
        imageSpinner = findViewById(R.id.imageSpinner)
        nextButton = findViewById(R.id.nextButton)

        // Pasando la Información al Spinner del Array de Opciones
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Utils.imageNames)
        imageSpinner.adapter = adapter

        // Mantener la selección del Spinner al rotar
        if (savedInstanceState != null) {
            imageSpinner.setSelection(savedInstanceState.getInt(Utils.spinnerPosition))
        }

        // LLamando a la Actividad: ImageActivity, para mostrar la imagen
        nextButton.setOnClickListener {
            val selectedImage = imageSpinner.selectedItemPosition
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(Utils.imageIndex, selectedImage)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar la posición seleccionada del Spinner
        outState.putInt(Utils.spinnerPosition, imageSpinner.selectedItemPosition)
    }
}
