package com.ppdm.app_musica.controlador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ppdm.app_musica.R

class AudioListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var audioListAdapter: AudioListAdapter
    private val audioList = listOf(
        Audio("Audio 1", R.drawable.audio1_img, "3:45"),
        Audio("Audio 2", R.drawable.audio2_img, "4:10"),
        Audio("Audio 3", R.drawable.audio3_img, "2:30"),
        Audio("Audio 4", R.drawable.audio4_img, "5:00"),
        Audio("Audio 5", R.drawable.audio5_img, "4:05")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        audioListAdapter = AudioListAdapter(audioList) { audio ->
            val action = AudioListFragmentDirections.actionAudioListFragmentToAudioDetailFragment(audio)
            findNavController().navigate(action)
        }
        recyclerView.adapter = audioListAdapter
        return view
    }
}
