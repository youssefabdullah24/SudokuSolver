package com.example.sudokusolver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {
    private var _board = MutableLiveData<Array<IntArray>>()
    val board: LiveData<Array<IntArray>> get() = _board

    init {
        resetBoard()
    }

    fun resetBoard() {
        _board.value = Array(9) { IntArray(9) { 0 } }
    }

    fun solve(): Boolean {
        var row = -1
        var col = -1

        x@ for (r in 0..8) {
            for (c in 0..8) {
                if (_board.value!![r][c] == 0) {
                    row = r
                    col = c
                    break@x
                }
            }
        }

        if (row == -1 || col == -1) {
            return true
        }

        for (i in 1..9) {
            _board.value!![row][col] = i
            if (checkCells(row, col)) {
                if (solve()) {
                    return true
                }
            }
            _board.value!![row][col] = 0
        }
        return false

    }

    fun setCell(r: Int, c: Int, value: Int) {
        if (r > -1 && c > -1) {
            _board.value!![r][c] = value
        }
    }

    fun isValidBoard(board: Array<IntArray>): Boolean {
        for (i in 0..8) {
            val validRow = isValidRow(board, i)
            val validCol = isValidCol(board, i)
            if (!validRow || !validCol) {
                return false
            }
        }
        return isValidBLock(board)
    }

    private fun checkCells(r: Int, c: Int): Boolean {
        if (r > -1 && c > -1) {
            if (_board.value!![r][c] > 0) {
                // h v check
                for (i in 0..8) {
                    if (_board.value!![i][c] == _board.value!![r][c] && r != i) {
                        return false
                    }

                    if (_board.value!![r][i] == _board.value!![r][c] && c != i) {
                        return false
                    }
                }
                // box check
                val boxRow = r / 3
                val boxCol = c / 3
                for (i in boxRow * 3 until boxRow * 3 + 3) {
                    for (j in boxCol * 3 until boxCol * 3 + 3) {
                        if (_board.value!![i][j] == _board.value!![r][c] && r != i && c != j) {
                            return false
                        }
                    }
                }

            }
        }
        return true

    }
    private fun isValidBLock(board: Array<IntArray>): Boolean {
        for (row in 0 until 9 step 3) {
            for (col in 0 until 9 step 3) {
                val set: MutableSet<Int> = HashSet()
                for (r in row until row + 3) {
                    for (c in col until col + 3) {
                        if (board[r][c] < 0 || board[r][c] > 9) {
                            return false
                        } else if (board[r][c] != 0) {
                            if (!set.add(board[r][c])) {
                                return false
                            }
                        }
                    }
                }
            }
        }
        return true
    }

    private fun isValidRow(board: Array<IntArray>, r: Int): Boolean {
        val curCell = board[r]
        val set: MutableSet<Int> = HashSet()
        for (value in curCell) {
            if (value < 0 || value > 9) {
                return false
            } else if (value != 0) {
                if (!set.add(value)) {
                    return false
                }
            }
        }
        return true
    }

    private fun isValidCol(board: Array<IntArray>, c: Int): Boolean {
        val set: MutableSet<Int> = HashSet()
        for (i in 0..8) {
            if (board[i][c] < 0 || board[i][c] > 9) {
                return false
            } else if (board[i][c] != 0) {
                if (!set.add(board[i][c])) {
                    return false
                }
            }
        }
        return true
    }


}