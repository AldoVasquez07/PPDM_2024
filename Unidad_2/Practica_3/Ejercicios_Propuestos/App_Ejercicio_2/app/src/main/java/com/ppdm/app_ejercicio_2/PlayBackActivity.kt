package com.ppdm.app_ejercicio_2

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlayBackActivity : AppCompatActivity() {
    private lateinit var audioImage: ImageView
    private lateinit var audioTitle: TextView
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button

    private var mediaPlayer: MediaPlayer? = null
    private var currentAudioIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playback)

        audioImage = findViewById(R.id.audioImage)
        audioTitle = findViewById(R.id.audioTitle)
        playButton = findViewById(R.id.playButton)
        pauseButton = findViewById(R.id.pauseButton)
        stopButton = findViewById(R.id.stopButton)

        // Obtener el índice del audio seleccionado
        currentAudioIndex = intent.getIntExtra("audio_index", 0)
        val audioFiles = arrayOf(
            R.raw.a_king_of_magic,
            R.raw.better,
            R.raw.creep,
            R.raw.every_breath_you_take,
            R.raw.someone_to_spend_time_with
        )

        // Establecer el título del audio
        audioTitle.text = Utils.audioNames[currentAudioIndex]

        // Establecer el archivo de audio y el ícono
        mediaPlayer = MediaPlayer.create(this, audioFiles[currentAudioIndex])
        setAudioImage(currentAudioIndex)

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
