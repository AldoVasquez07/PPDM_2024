package com.ppdm.app_musica.controlador

class AudioListAdapter(
    private val audioList: List<Audio>,
    private val onItemClicked: (Audio) -> Unit
) : RecyclerView.Adapter<AudioListAdapter.AudioViewHolder>() {

    inner class AudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val audioImageView: ImageView = view.findViewById(R.id.audio_image)
        val audioNameTextView: TextView = view.findViewById(R.id.audio_name)
        val audioDurationTextView: TextView = view.findViewById(R.id.audio_duration)

        fun bind(audio: Audio) {
            audioImageView.setImageResource(audio.imageResId)
            audioNameTextView.text = audio.name
            audioDurationTextView.text = audio.duration

            itemView.setOnClickListener {
                onItemClicked(audio)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.audio_item, parent, false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        holder.bind(audioList[position])
    }

    override fun getItemCount(): Int = audioList.size
}
