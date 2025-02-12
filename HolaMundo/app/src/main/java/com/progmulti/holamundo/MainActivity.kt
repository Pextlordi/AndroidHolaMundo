package com.progmulti.holamundo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var counter = 0
    lateinit var textview : TextView
    val etiquetaLog = "Hola_Mundo_MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textview = findViewById(R.id.tvCounter)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        incrementButton.setOnClickListener() {
            counter++
            updateCounterTextView()
        }

        val decrementButton = findViewById<Button>(R.id.decrementButton)
        decrementButton.setOnClickListener() {
            if (counter > 0) {
                counter--
            }
            updateCounterTextView()
        }

        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener() {
            counter = 0
            updateCounterTextView()
        }

        val botonAbrir = findViewById<Button>(R.id.openButton)
        botonAbrir.setOnClickListener() {
            val intent = Intent(this, TextEditActivity::class.java)
            startActivity(intent)
        }
    }

    fun updateCounterTextView() {
        textview.text = counter.toString()
    }

    override fun onStart() {
        super.onStart()

        Log.d(etiquetaLog, "Método onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(etiquetaLog, "Método onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d(etiquetaLog, "Método onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d(etiquetaLog, "Método onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(etiquetaLog, "Método onDestroy")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d(etiquetaLog, "Método onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("VALORCONTADOR", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("VALORCONTADOR",0)
        updateCounterTextView()
    }
}