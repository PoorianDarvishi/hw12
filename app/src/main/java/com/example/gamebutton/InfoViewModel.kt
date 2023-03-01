package com.example.gamebutton

import androidx.lifecycle.ViewModel

class InfoViewModel : ViewModel() {
    private var player1 = "X"
    private var player2 = "O"
    private var numberColumn = 5
    fun setPlayer1(name: String) {
        player1 = name
    }

    fun getPlayer1(): String {
        return player1
    }

    fun setPlayer2(name: String) {
        player2 = name
    }

    fun getPlayer2(): String {
        return player2
    }

    fun setColumn(number: Int): Boolean {
        if (number >= 5) {
            numberColumn = number
            println("ali")
            return true
        }
        return false
    }

    fun getColumn(): Int {
        return numberColumn
    }
}