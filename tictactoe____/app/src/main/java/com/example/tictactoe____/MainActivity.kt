package com.example.tictactoe____

import android.graphics.Color import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View import android.widget.Button
import android.widget.EditText
import android.widget.Toast import androidx.appcompat.app.AlertDialog import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import java.util.*

class MainActivity : AppCompatActivity(),player_names {

    lateinit var player_x:EditText
    lateinit var player_o:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        player_x=findViewById(R.id.name_1)
        player_x.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                player_names(1,player_x.text.toString())
            }
        })
        player_o=findViewById(R.id.name_2)
        player_o.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                player_names(2,player_o.text.toString())
            }
        })
    }

    override fun player_names(id: Int, name: String) {
        val obj = supportFragmentManager.findFragmentById(R.id.tictactoe_fragment) as tictactoefragment
        obj.player_names(id,name)
    }
    fun restartGame(view: View) {
        val fragment = supportFragmentManager.findFragmentById(R.id.tictactoe_fragment) as tictactoefragment
        fragment.restartGame()
    }
}