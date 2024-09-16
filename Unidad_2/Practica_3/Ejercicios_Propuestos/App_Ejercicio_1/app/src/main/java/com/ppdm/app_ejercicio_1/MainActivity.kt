package com.ppdm.app_ejercicio_1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSpinner = findViewById(R.id.imageSpinner)
        nextButton = findViewById(R.id.nextButton)

        val imageNames = arrayOf("Image 1", "Image 2", "Image 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        imageSpinner.adapter = adapter

        // Mantener la selección del Spinner al rotar
        if (savedInstanceState != null) {
            imageSpinner.setSelection(savedInstanceState.getInt("spinner_position"))
        }

        nextButton.setOnClickListener {
            val selectedImage = imageSpinner.selectedItemPosition
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("image_index", selectedImage)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar la posición seleccionada del Spinner
        outState.putInt("spinner_position", imageSpinner.selectedItemPosition)
    }
}