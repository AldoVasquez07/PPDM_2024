package com.ppdm.app_ejercicio_1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageView = findViewById(R.id.imageView)
        backButton = findViewById(R.id.backButton)


        val imageIndex = intent.getIntExtra("image_index", 0)

        // Lista de Imagenes
        val images = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        // Renderizar la Imagen deseada
        imageView.setImageResource(images[imageIndex])

        // Retornar a la Funcion Anterior
        backButton.setOnClickListener {
            finish()
        }
    }
}
