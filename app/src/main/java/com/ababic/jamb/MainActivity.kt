package com.ababic.jamb

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_players.*

class MainActivity : AppCompatActivity() {

    class Igrac(playerFlag: Int, score: Int) {

        var playerFlag = 0;
        var score = 0;
        var totalScore = 0;

        fun addScore (score: Int) {
           totalScore += score;
        }
    }

    var x = 0;
    var igraci = List(Integer.parseInt(brIgraca.toString())) { Igrac(x, 0) };

    var kockica: IntArray = intArrayOf(1, 2, 3, 4, 5, 6)
    var trenutnoStanjeKockica: IntArray = intArrayOf(1, 2, 3, 4, 5, 6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(x in 0 until (Integer.parseInt(brIgraca.toString())-1)) {
            igraci[x].playerFlag = x;
        }

        var i = 0;
        for(i in 0 until (Integer.parseInt(brIgraca.toString())-1)) {
            igraj(igraci[i].playerFlag);
        }
    }

    private fun baciKockicu(): Int {
        var valueKockice = (1..6).random();
        var i = 0;
        for(i in 0 until 5) {
            if(valueKockice == kockica[i]) {
                return kockica[i];
            }
            else {
                Toast.makeText(this, "Greška u pronalasku broja kockice", Toast.LENGTH_LONG).show()
            }
        }
        return 0;
    }
    private fun randomSveKockice() {
        for(i in 0 until 5) {
            trenutnoStanjeKockica[i] = baciKockicu();
        }
        for(i in 0 until 5) {
            if(trenutnoStanjeKockica[i] == 1) diceFirst.setImageResource(R.drawable.one);
            if(trenutnoStanjeKockica[i] == 2) diceFirst.setImageResource(R.drawable.two);
            if(trenutnoStanjeKockica[i] == 3) diceFirst.setImageResource(R.drawable.three);
            if(trenutnoStanjeKockica[i] == 4) diceFirst.setImageResource(R.drawable.four);
            if(trenutnoStanjeKockica[i] == 5) diceFirst.setImageResource(R.drawable.five);
            if(trenutnoStanjeKockica[i] == 6) diceFirst.setImageResource(R.drawable.six);
        }
    }

    private fun igraj(flagIgraca: Int) {
        igrac.text = ("Igrač $flagIgraca")
        baciKockice.setOnClickListener {
            randomSveKockice();
        }
    }
}


