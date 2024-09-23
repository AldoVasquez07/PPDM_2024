package com.ppdm.app_ejercicio_2.modelos

import androidx.fragment.app.Fragment
import com.ppdm.app_ejercicio_2.R

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

class MusicDisplayFragment : AppCompatActivity() {
    private lateinit var audioImage: ImageView
    private lateinit var audioTitle: TextView
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button

    private var mediaPlayer: MediaPlayer? = null
    private val viewModel: MusicViewModel by viewModels() // Usando un ViewModel
    private var currentAudioIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_music_display)

        // Inicializando los elementos UI
        audioImage = findViewById(R.id.audioImage)
        audioTitle = findViewById(R.id.audioTitle)
        playButton = findViewById(R.id.playButton)
        pauseButton = findViewById(R.id.pauseButton)
        stopButton = findViewById(R.id.stopButton)

        // Observar el índice de audio seleccionado desde el ViewModel
        viewModel.selectedMusicIndex.observe(this) { index ->
            currentAudioIndex = index

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
            mediaPlayer = MediaPlayer.create(this, audioFiles[currentAudioIndex])
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
    }

    // Método para configurar la imagen correspondiente al audio
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
