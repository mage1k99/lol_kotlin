package io.chillout.diceroller

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.chillout.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var diceno = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mydata: Mydata = Mydata(getString(R.string.dice_button_text))
        binding.mydata = mydata
        binding.rollButton.setOnClickListener {
            rollDice(binding.diceImage)
        }
        binding.savebtn.setOnClickListener{
            var usertext : String = binding.nicknameEdit.text.toString()

            val intent: Intent= Intent(this, hobbies::class.java).putExtra("Name",usertext).apply { putExtra("dice",diceno) }
            startActivity(intent)
        }
    }

    private fun rollDice(diceImage: ImageView) {
        diceno = Random.nextInt(6) + 1
        val drawableRs = when (diceno) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableRs)
    }

}
