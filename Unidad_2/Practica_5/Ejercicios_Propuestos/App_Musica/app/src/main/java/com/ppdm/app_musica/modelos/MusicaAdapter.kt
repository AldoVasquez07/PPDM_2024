package com.ppdm.app_musica.modelos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ppdm.app_musica.R

class MusicaAdapter(
    private val musicaList: List<Musica>,
    private val onItemClicked: (Musica) -> Unit
) : RecyclerView.Adapter<MusicaAdapter.AudioViewHolder>() {

    inner class AudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val audioImageView: ImageView = view.findViewById(R.id.audioImage)
        val audioNameTextView: TextView = view.findViewById(R.id.audioName)
        val audioDurationTextView: TextView = view.findViewById(R.id.audioDuration)

        fun bind(musica: Musica) {
            audioImageView.setImageResource(musica.logoId)
            audioNameTextView.text = musica.nombre
            audioDurationTextView.text = musica.duracion

            itemView.setOnClickListener {
                onItemClicked(musica)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.musica, parent, false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        holder.bind(musicaList[position])
    }

    override fun getItemCount(): Int = musicaList.size
}
