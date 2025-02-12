package com.progmulti.holamundo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TextEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.secondary_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textConfig)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonVolver = findViewById<Button>(R.id.backButton)
        botonVolver.setOnClickListener() {
            finish()
        }

        val textoModificar = findViewById<TextView>(R.id.textoInfo)

        val barraColor = findViewById<SeekBar>(R.id.barraColor)
        barraColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val hsv = floatArrayOf(progress.toFloat(), 1f, 1f)
                val color = Color.HSVToColor(hsv)
                textoModificar.setTextColor(color)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        val barraTamanyo = findViewById<SeekBar>(R.id.barraTamanyo)
        barraTamanyo.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textoModificar.textSize = progress.toFloat()+20F;
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

}