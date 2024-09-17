package com.ppdm.app_ejercicio_2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.ppdm.app_ejercicio_2.PlayBackActivity
import com.ppdm.app_ejercicio_2.R
import com.ppdm.app_ejercicio_2.Utils

class MainActivity : AppCompatActivity() {
    private lateinit var audioSpinner: Spinner
    private lateinit var selectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioSpinner = findViewById(R.id.audioSpinner)
        selectButton = findViewById(R.id.nextButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            Utils.audioNames)
        audioSpinner.adapter = adapter

        selectButton.setOnClickListener {
            val selectedAudio = audioSpinner.selectedItemPosition
            val intent = Intent(this, PlayBackActivity::class.java)
            intent.putExtra(Utils.audioIndex, selectedAudio)
            startActivity(intent)
        }
    }
}
