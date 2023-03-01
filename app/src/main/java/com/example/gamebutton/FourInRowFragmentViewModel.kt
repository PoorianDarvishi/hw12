package com.example.gamebutton


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FourInRowFragmentViewModel : ViewModel() {

    private var listPlace = ArrayList<String>()
    private var rowAndColumn = 5

    fun getColumn(): Int {
        return rowAndColumn
    }

    fun changeRowAndColumn(createRowAndColumn: Int) {
        rowAndColumn = createRowAndColumn
        fetchData(rowAndColumn)
    }

    private fun fetchData(createRowAndColumn: Int) {
        for (i in 0 until createRowAndColumn * createRowAndColumn) {
            listPlace.add("")
        }
    }

    private val listChoosePlayerOne = mutableSetOf<Int>()
    private val listChoosePlayerTwo = mutableSetOf<Int>()
    private var statusPlayer = StatusPlayerFourRow.PLAYER1
    private var namePlayerOne = "X"
    private var namePlayerTwo = "O"
    val player = MutableLiveData(namePlayerOne)
    var status = arrayListOf(false)
    fun setPlayers(player1: String, player2: String) {
        namePlayerOne = player1
        namePlayerTwo = player2
        player.value = namePlayerOne
    }

    fun getListPlace(): ArrayList<String> {
        return listPlace
    }

    private fun changeStatus() {
        statusPlayer = if (statusPlayer == StatusPlayerFourRow.PLAYER1) {
            player.value = namePlayerTwo
            StatusPlayerFourRow.PLAYER2
        } else {
            player.value = namePlayerOne
            StatusPlayerFourRow.PLAYER1
        }
    }

    fun choosePlace(place: Int): ArrayList<String> {
        var location = place % rowAndColumn + ((rowAndColumn - 1) * rowAndColumn)
        for (index in 0 until rowAndColumn) {
            if (listPlace[location] == "") {
                listPlace[location] = choose(location)
                break
            } else location -= rowAndColumn
        }
        return listPlace
    }

    private fun choose(place: Int): String {
        return if (statusPlayer == StatusPlayerFourRow.PLAYER1) {
            changeStatus()
            listChoosePlayerOne.add(place)
            if (check(listChoosePlayerOne)) {
                status[0] = true
                player.value = "$namePlayerOne Win"
            }
            namePlayerOne
        } else {
            changeStatus()
            listChoosePlayerTwo.add(place)
            if (check(listChoosePlayerTwo)) {
                status[0] = true
                player.value = "$namePlayerTwo Win"
            }
            namePlayerTwo
        }
    }

    private fun check(listChoose: MutableSet<Int>): Boolean {
        return when {
            winVertical(listChoose) -> {
                true
            }
            winHorizontal(listChoose) -> {
                true
            }
            winDiagonal(listChoose) -> {
                true
            }
            else -> winDiagonalRevers(listChoose)
        }
    }

    private fun winVertical(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn) {
            var count = 0
            for (j in i until rowAndColumn * rowAndColumn step rowAndColumn) {
                if (j in listChoose) {
                    count++
                    if (count == 4) return true
                } else {
                    count = 0
                }
            }
        }
        return false
    }


    private fun winHorizontal(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn * rowAndColumn step rowAndColumn) {
            var count = 0
            for (j in i..i + 4) {
                if (j in listChoose) {
                    count++
                    if (count == 4) return true
                } else {
                    count = 0
                }
            }
        }
        return false
    }

    private fun winDiagonal(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn * rowAndColumn) {
            var count = 0
            var step = rowAndColumn
            var num = 0
            var number: Int
            for (_i in 0 until rowAndColumn * 2 - 1) {
                if (num >= rowAndColumn * (rowAndColumn - 1)) {
                    step = 1
                }
                number = num
                for (j in 0..num / (rowAndColumn - 1)) {
                    if (number in listChoose) {
                        count++
                        if (count == 4) {
                            return true
                        }
                    } else {
                        count = 0
                    }
                    number -= rowAndColumn - 1
                }
                num += step
            }
        }
        return false
    }

    private fun winDiagonalRevers(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn * rowAndColumn) {
            var count = 0
            var step = rowAndColumn
            var num = rowAndColumn - 1
            var number: Int
            for (_i in 0 until rowAndColumn * 2 - 1) {
                if (num >= rowAndColumn * (rowAndColumn - 1)) {
                    step = -1
                }
                number = num
                for (j in 0..num / (rowAndColumn - 1)) {
                    if (number in listChoose) {
                        count++
                        if (count == 4) {
                            return true
                        }
                    } else {
                        count = 0
                    }
                    number -= rowAndColumn + 1
                }
                num += step
            }
        }
        return false
    }

    fun reset() {
        listPlace.clear()
        listChoosePlayerTwo.clear()
        listChoosePlayerOne.clear()
        statusPlayer = StatusPlayerFourRow.PLAYER1
        status[0] = false
    }

    fun checkWin(): Boolean {
        return status[0]
    }
}