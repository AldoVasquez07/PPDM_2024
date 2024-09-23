package com.ppdm.app_ejercicio_2.modelos

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ppdm.app_ejercicio_2.R

class MusicDisplayFragment : Fragment() {
    private lateinit var audioImage: ImageView
    private lateinit var audioTitle: TextView
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button

    private var mediaPlayer: MediaPlayer? = null
    private val viewModel: MusicViewModel by activityViewModels() // Usando un ViewModel
    private var currentAudioIndex: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music_display, container, false)

        // Inicializando los elementos UI
        audioImage = view.findViewById(R.id.audioImage)
        audioTitle = view.findViewById(R.id.audioTitle)
        playButton = view.findViewById(R.id.playButton)
        pauseButton = view.findViewById(R.id.pauseButton)
        stopButton = view.findViewById(R.id.stopButton)

        // Observar el índice de audio seleccionado desde el ViewModel
        viewModel.selectedMusicIndex.observe(viewLifecycleOwner) { index ->
            currentAudioIndex = index
            updateUI() // Actualizar la UI
        }

        // Configurar los listeners para los botones
        playButton.setOnClickListener {
            mediaPlayer?.start()
        }

        pauseButton.setOnClickListener {
            mediaPlayer?.pause()
        }

        stopButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.prepare() // Preparar para futuras reproducciones
        }

        return view
    }

    private fun updateUI() {
        // Lista de archivos de audio
        val audioFiles = arrayOf(
            R.raw.a_king_of_magic,
            R.raw.better,
            R.raw.creep,
            R.raw.every_breath_you_take,
            R.raw.someone_to_spend_time_with
        )

        // Establecer el título del audio y la imagen
        audioTitle.text = Utils.musicNames[currentAudioIndex]
        setAudioImage(currentAudioIndex)

        // Inicializar el MediaPlayer con el audio correspondiente
        mediaPlayer?.release() // Liberar cualquier MediaPlayer existente
        mediaPlayer = MediaPlayer.create(requireContext(), audioFiles[currentAudioIndex])
    }

    private fun setAudioImage(index: Int) {
        val imageResId = when (index) {
            0 -> R.drawable.queen_logo
            1 -> R.drawable.guns_logo
            2 -> R.drawable.radiohead_logo
            3 -> R.drawable.thepolice_logo
            4 -> R.drawable.losretros_logo
            else -> R.drawable.music_icon // Imagen por defecto
        }
        audioImage.setImageResource(imageResId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
