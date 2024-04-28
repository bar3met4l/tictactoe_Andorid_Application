package com.example.tictactoe____

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.Random


class tictactoefragment : Fragment() {

    lateinit var button1:Button
    lateinit var button2:Button
    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var button5:Button
    lateinit var button6:Button
    lateinit var button7:Button
    lateinit var button8:Button
    lateinit var button9:Button

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1
    private var setPlayer = 1
    var player_x=""
    var player_o=""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view= inflater.inflate(R.layout.fragment_tictactoefragment,container,false)

        button1 = view.findViewById(R.id.button1)
        button2 = view.findViewById(R.id.button2)
        button3 = view.findViewById(R.id.button3)
        button4 = view.findViewById(R.id.button4)
        button5 = view.findViewById(R.id.button5)
        button6 = view.findViewById(R.id.button6)
        button7 = view.findViewById(R.id.button7)
        button8 = view.findViewById(R.id.button8)
        button9 = view.findViewById(R.id.button9)

        initializeGame()

        return view
    }
    fun player_names(id:Int, name:String){
        if(id==1){
            player_x=name
        }
        else
        {
           player_o=name
        }
    }
    private fun initializeGame(){
        button1.setOnClickListener { buttonClick(it) }
        button2.setOnClickListener { buttonClick(it) }
        button3.setOnClickListener { buttonClick(it) }
        button4.setOnClickListener { buttonClick(it) }
        button5.setOnClickListener { buttonClick(it) }
        button6.setOnClickListener { buttonClick(it) }
        button7.setOnClickListener { buttonClick(it) }
        button8.setOnClickListener { buttonClick(it) }
        button9.setOnClickListener { buttonClick(it) }

    }
    fun restartGame() {
        val buttons = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (button in buttons) {
            button.setBackgroundResource(android.R.drawable.btn_default)
            button.text = ""
            button.isEnabled = true
        }

        player1.clear()
        player2.clear()
        activePlayer = 1
        setPlayer = 1
    }



    fun buttonClick(view: View) {
        val button = view as Button
        var cellId = 0

        when (button.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        playGame(cellId, button)
    }
    fun playGame(cellId: Int, button: Button) {
        if (activePlayer == 1) {
            button.text = "X"
            player1.add(cellId)
            activePlayer = 2

        } else {
            button.text = "O"

            player2.add(cellId)
            activePlayer = 1
        }
        button.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // Check rows
        if (player1.containsAll(listOf(1, 2, 3)) || player1.containsAll(listOf(4, 5, 6)) || player1.containsAll(listOf(7, 8, 9))) {
            winner = 1
        }
        if (player2.containsAll(listOf(1, 2, 3)) || player2.containsAll(listOf(4, 5, 6)) || player2.containsAll(listOf(7, 8, 9))) {
            winner = 2
        }

        // Check columns
        if (player1.containsAll(listOf(1, 4, 7)) || player1.containsAll(listOf(2, 5, 8)) || player1.containsAll(listOf(3, 6, 9))) {
            winner = 1
        }
        if (player2.containsAll(listOf(1, 4, 7)) || player2.containsAll(listOf(2, 5, 8)) || player2.containsAll(listOf(3, 6, 9))) {
            winner = 2
        }

        // Check diagonals
        if (player1.containsAll(listOf(1, 5, 9)) || player1.containsAll(listOf(3, 5, 7))) {
            winner = 1
        }
        if (player2.containsAll(listOf(1, 5, 9)) || player2.containsAll(listOf(3, 5, 7))) {
            winner = 2
        }

        if (winner != -1) {
            if(player_x==""){
                player_x="player 1"
            }
            if(player_o=="")
            {
                player_o="player 2"
            }
            val builder = AlertDialog.Builder(requireActivity())
            builder.setTitle(if (winner == 1) "$player_x wins!!" else "$player_o Wins!!")
            builder.setMessage("better luck next time ${if (winner == 1) player_o else player_x}")

            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                stopTouch()
            }

            val dialog = builder.create()
            dialog.show()
        }
    }
    fun stopTouch() {
        val buttons = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (button in buttons) {
            button.isEnabled = false
        }
    }


}