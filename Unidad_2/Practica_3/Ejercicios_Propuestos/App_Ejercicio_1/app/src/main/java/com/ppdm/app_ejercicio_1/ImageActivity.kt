package com.ppdm.app_ejercicio_1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    // Declarando Atributos
    private lateinit var imageView: ImageView
    private lateinit var backButton: Button
    private lateinit var headerText: TextView
    private var imageIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // Realizando búsqueda de los componentes XML
        imageView = findViewById(R.id.imageView)
        backButton = findViewById(R.id.backButton)
        headerText = findViewById(R.id.headerText)

        // Recuperar el índice de la imagen del Intent o del estado guardado
        val savedImageIndex = savedInstanceState?.getInt(Utils.savedImageIndex)
        imageIndex = intent.getIntExtra(Utils.imageIndex, savedImageIndex ?: 0)

        updateHeaderText(Utils.imageNames[imageIndex])

        // Lista de imágenes
        val images = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        // Validar el índice para evitar errores
        val validIndex = imageIndex.coerceIn(images.indices)
        imageView.setImageResource(images[validIndex])

        // Configurar el botón para regresar a la actividad anterior
        backButton.setOnClickListener {
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar el índice de la imagen en el estado guardado
        outState.putInt(Utils.savedImageIndex, imageIndex)
    }

    private fun updateHeaderText(text: String) {
        // Cambiando la cabecera de la Imagen
        headerText.text = text
    }
}

