package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_btn)
        diceImage= findViewById(R.id.result_text)

        rollButton.setOnClickListener{
            rollDice()


        }

    }


     private fun rollDice(){
        val random = Random.nextInt(6)+1

        val drawableResource = when (random){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //This is probably not how you animate stuff
        //As a matter of fact, it breaks if you press the button repeatedly
        diceImage.animate().apply{
            duration = 100
            rotationYBy(60f)
        }.withEndAction{diceImage.animate().apply{
            duration = 100
            rotationYBy(-60f)
        }

        }.start()

        diceImage.setImageResource(drawableResource)

    }

}