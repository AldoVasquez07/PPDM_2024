package com.ppdm.app_ejercicio_1.modelos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ppdm.app_ejercicio_1.R

class ImageDisplayFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var backButton: Button
    private lateinit var headerText: TextView
    private val viewModel: ImageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_display, container, false)
        imageView = view.findViewById(R.id.imageView)
        backButton = view.findViewById(R.id.backButton)
        headerText = view.findViewById(R.id.headerText)

        // Observar el índice de imagen seleccionado
        viewModel.selectedImageIndex.observe(viewLifecycleOwner) { index ->
            headerText.text = Utils.imageNames[index]

            // Lista de imágenes
            val images = arrayOf(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3
            )

            val validIndex = index.coerceIn(images.indices)
            imageView.setImageResource(images[validIndex])
        }

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }
}