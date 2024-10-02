package com.ppdm.app_musica.controlador

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ppdm.app_musica.R

class AudioDetailFragment : Fragment() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var audio: Audio
    private var isPlaying = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_detail, container, false)

        // Recibir el objeto audio del bundle
        audio = AudioDetailFragmentArgs.fromBundle(requireArguments()).audio

        // Configurar los elementos UI
        val audioImageView: ImageView = view.findViewById(R.id.audio_detail_image)
        val audioNameTextView: TextView = view.findViewById(R.id.audio_detail_name)
        val playButton: Button = view.findViewById(R.id.btn_play)
        val pauseButton: Button = view.findViewById(R.id.btn_pause)
        val stopButton: Button = view.findViewById(R.id.btn_stop)

        audioImageView.setImageResource(audio.imageResId)
        audioNameTextView.text = audio.name

        // Inicializar MediaPlayer con el audio seleccionado
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.better)

        // Listeners para los botones
        playButton.setOnClickListener {
            if (!isPlaying) {
                mediaPlayer.start()
                isPlaying = true
            }
        }

        pauseButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
            }
        }

        stopButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer = MediaPlayer.create(requireContext(), R.raw.nombre_del_audio)
                isPlaying = false
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
