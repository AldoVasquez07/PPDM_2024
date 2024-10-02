package com.ppdm.app_musica.modelos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppdm.app_musica.R

class AudioListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var audioAdapter: MusicaAdapter
    private val audioList = listOf(
        Musica("Better",
            R.drawable.guns_logo,
            "04:57",
            R.raw.better
        ),
        Musica("Every Brath you Take",
            R.drawable.thepolice_logo,
            "04:13",
            R.raw.every_breath_you_take
        ),
        Musica("Creep",
            R.drawable.radiohead_logo,
            "02:30",
            R.raw.creep
        ),
        Musica("Someone To Spend Time With",
            R.drawable.losretros_logo,
            "03:58",
            R.raw.someone_to_spend_time_with
        ),
        Musica("A kind of Magic",
            R.drawable.queen_logo,
            "04:24",
            R.raw.a_king_of_magic)
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.musica_list_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Al seleccionar un ítem del RecyclerView, se pasa el objeto AudioItem al fragmento de reproducción.
        audioAdapter = MusicaAdapter(audioList) { musica ->
            val fragment = AudioPlayerFragment.newInstance(musica)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = audioAdapter
        return view
    }
}
