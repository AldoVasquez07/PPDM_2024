package com.ppdm.app_ejercicio_2.modelos

import com.ppdm.app_ejercicio_2.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class MusicSelectorFragment: Fragment() {
    private lateinit var musicSpinner: Spinner
    private lateinit var nextButton: Button
    private val viewModel: MusicViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        val view = inflater.inflate(R.layout.fragment_music_selector, container, false)
        musicSpinner = view.findViewById(R.id.musicSpinner)
        nextButton = view.findViewById(R.id.nextButton)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, Utils.musicNames)
        musicSpinner.adapter = adapter

        nextButton.setOnClickListener {
            val selectedMusic = musicSpinner.selectedItemPosition
            viewModel.selectMusic(selectedMusic)
            findNavController().navigate(R.id.action_musicSelectorFragment_to_musicDisplayFragment)
        }

        return view
    }


}