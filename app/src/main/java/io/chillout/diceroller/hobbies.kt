package io.chillout.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.chillout.diceroller.databinding.ActivityHobbiesBinding

class hobbies : AppCompatActivity() {
    lateinit var hobbiesBinding: ActivityHobbiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hobbiesBinding = DataBindingUtil.setContentView(this,R.layout.activity_hobbies)
        var name = intent.extras?.getString("Name")
        var diceno = intent.extras?.getInt("dice")
        hobbiesBinding.nickName.text = name
        hobbiesBinding.diceRoll.text = diceno.toString()

    }
}
