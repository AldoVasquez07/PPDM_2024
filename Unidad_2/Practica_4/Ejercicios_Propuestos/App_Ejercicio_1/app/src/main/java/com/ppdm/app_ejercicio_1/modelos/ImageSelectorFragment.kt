package com.ppdm.app_ejercicio_1.modelos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.ppdm.app_ejercicio_1.R
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel

class ImageSelectorFragment: Fragment() {
    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button
    private val viewModel: ImageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        val view = inflater.inflate(R.layout.fragment_image_selector, container, false)
        imageSpinner = view.findViewById(R.id.imageSpinner)
        nextButton = view.findViewById(R.id.nextButton)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, Utils.imageNames)
        imageSpinner.adapter = adapter

        nextButton.setOnClickListener {
            val selectedImage = imageSpinner.selectedItemPosition
            viewModel.selectImage(selectedImage)
            findNavController().navigate(R.id.action_imageSelectorFragment_to_imageDisplayFragment)
        }

        return view
    }
}