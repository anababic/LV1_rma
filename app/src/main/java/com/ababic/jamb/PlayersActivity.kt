package com.ababic.jamb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_players.*

class PlayersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        setupListeners()
    }

    private fun setupListeners() {
        igraj.setOnClickListener {
            var brojIgraca: Int = brIgraca.text.toString().toInt();
            print(brojIgraca);
            if(brojIgraca < 1 || brojIgraca >= 8) {
                Toast.makeText(this, "Molim unesite ispravan broj igrača veći od 1 i manji od 8", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}