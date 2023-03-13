package com.example.sudokusolver

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sudokusolver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.board.observe(this) {
            setNewBoard(it)
        }
        binding.resetBoardButton.setOnClickListener {
            viewModel.resetBoard()
        }

        binding.submitPuzzleButton.setOnClickListener {
            setBoardCells()
            if (viewModel.isValidBoard(viewModel.board.value!!)) {
                viewModel.solve()
                val new = viewModel.board.value!!
                setNewBoard(new)
            } else {
                Toast.makeText(this, "Board is Invalid", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun setNewBoard(newBoard: Array<IntArray>) {
        binding.apply {
            editText00.setText(newBoard[0][0].toString())
            editText01.setText(newBoard[0][1].toString())
            editText02.setText(newBoard[0][2].toString())
            editText03.setText(newBoard[0][3].toString())
            editText04.setText(newBoard[0][4].toString())
            editText05.setText(newBoard[0][5].toString())
            editText06.setText(newBoard[0][6].toString())
            editText07.setText(newBoard[0][7].toString())
            editText08.setText(newBoard[0][8].toString())

            editText10.setText(newBoard[1][0].toString())
            editText11.setText(newBoard[1][1].toString())
            editText12.setText(newBoard[1][2].toString())
            editText13.setText(newBoard[1][3].toString())
            editText14.setText(newBoard[1][4].toString())
            editText15.setText(newBoard[1][5].toString())
            editText16.setText(newBoard[1][6].toString())
            editText17.setText(newBoard[1][7].toString())
            editText18.setText(newBoard[1][8].toString())

            editText20.setText(newBoard[2][0].toString())
            editText21.setText(newBoard[2][1].toString())
            editText22.setText(newBoard[2][2].toString())
            editText23.setText(newBoard[2][3].toString())
            editText24.setText(newBoard[2][4].toString())
            editText25.setText(newBoard[2][5].toString())
            editText26.setText(newBoard[2][6].toString())
            editText27.setText(newBoard[2][7].toString())
            editText28.setText(newBoard[2][8].toString())

            editText30.setText(newBoard[3][0].toString())
            editText31.setText(newBoard[3][1].toString())
            editText32.setText(newBoard[3][2].toString())
            editText33.setText(newBoard[3][3].toString())
            editText34.setText(newBoard[3][4].toString())
            editText35.setText(newBoard[3][5].toString())
            editText36.setText(newBoard[3][6].toString())
            editText37.setText(newBoard[3][7].toString())
            editText38.setText(newBoard[3][8].toString())

            editText40.setText(newBoard[4][0].toString())
            editText41.setText(newBoard[4][1].toString())
            editText42.setText(newBoard[4][2].toString())
            editText43.setText(newBoard[4][3].toString())
            editText44.setText(newBoard[4][4].toString())
            editText45.setText(newBoard[4][5].toString())
            editText46.setText(newBoard[4][6].toString())
            editText47.setText(newBoard[4][7].toString())
            editText48.setText(newBoard[4][8].toString())

            editText50.setText(newBoard[5][0].toString())
            editText51.setText(newBoard[5][1].toString())
            editText52.setText(newBoard[5][2].toString())
            editText53.setText(newBoard[5][3].toString())
            editText54.setText(newBoard[5][4].toString())
            editText55.setText(newBoard[5][5].toString())
            editText56.setText(newBoard[5][6].toString())
            editText57.setText(newBoard[5][7].toString())
            editText58.setText(newBoard[5][8].toString())

            editText60.setText(newBoard[6][0].toString())
            editText61.setText(newBoard[6][1].toString())
            editText62.setText(newBoard[6][2].toString())
            editText63.setText(newBoard[6][3].toString())
            editText64.setText(newBoard[6][4].toString())
            editText65.setText(newBoard[6][5].toString())
            editText66.setText(newBoard[6][6].toString())
            editText67.setText(newBoard[6][7].toString())
            editText68.setText(newBoard[6][8].toString())

            editText70.setText(newBoard[7][0].toString())
            editText71.setText(newBoard[7][1].toString())
            editText72.setText(newBoard[7][2].toString())
            editText73.setText(newBoard[7][3].toString())
            editText74.setText(newBoard[7][4].toString())
            editText75.setText(newBoard[7][5].toString())
            editText76.setText(newBoard[7][6].toString())
            editText77.setText(newBoard[7][7].toString())
            editText78.setText(newBoard[7][8].toString())

            editText80.setText(newBoard[8][0].toString())
            editText81.setText(newBoard[8][1].toString())
            editText82.setText(newBoard[8][2].toString())
            editText83.setText(newBoard[8][3].toString())
            editText84.setText(newBoard[8][4].toString())
            editText85.setText(newBoard[8][5].toString())
            editText86.setText(newBoard[8][6].toString())
            editText87.setText(newBoard[8][7].toString())
            editText88.setText(newBoard[8][8].toString())


        }
    }

    private fun setBoardCells() {
        binding.apply {
            if (editText00.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 0, editText00.text.toString().toInt())
            }
            if (editText01.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 1, editText01.text.toString().toInt())

            }
            if (editText02.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 2, editText02.text.toString().toInt())

            }
            if (editText03.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 3, editText03.text.toString().toInt())

            }
            if (editText04.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 4, editText04.text.toString().toInt())

            }
            if (editText05.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 5, editText05.text.toString().toInt())

            }
            if (editText06.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 6, editText06.text.toString().toInt())

            }
            if (editText07.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 7, editText07.text.toString().toInt())

            }
            if (editText08.text.trim().isNotEmpty()) {
                viewModel.setCell(0, 8, editText08.text.toString().toInt())

            }
            if (editText10.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 0, editText10.text.toString().toInt())

            }
            if (editText11.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 1, editText11.text.toString().toInt())


            }
            if (editText12.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 2, editText12.text.toString().toInt())


            }
            if (editText13.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 3, editText13.text.toString().toInt())


            }
            if (editText14.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 4, editText14.text.toString().toInt())


            }
            if (editText15.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 5, editText15.text.toString().toInt())


            }
            if (editText16.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 6, editText16.text.toString().toInt())


            }
            if (editText17.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 7, editText17.text.toString().toInt())


            }
            if (editText18.text.trim().isNotEmpty()) {
                viewModel.setCell(1, 8, editText18.text.toString().toInt())


            }
            if (editText20.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 0, editText20.text.toString().toInt())


            }
            if (editText21.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 1, editText21.text.toString().toInt())


            }
            if (editText22.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 2, editText22.text.toString().toInt())


            }
            if (editText23.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 3, editText23.text.toString().toInt())


            }
            if (editText24.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 4, editText24.text.toString().toInt())


            }
            if (editText25.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 5, editText25.text.toString().toInt())


            }
            if (editText26.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 6, editText26.text.toString().toInt())


            }
            if (editText27.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 7, editText27.text.toString().toInt())


            }
            if (editText28.text.trim().isNotEmpty()) {
                viewModel.setCell(2, 8, editText28.text.toString().toInt())


            }
            if (editText30.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 0, editText30.text.toString().toInt())


            }
            if (editText31.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 1, editText31.text.toString().toInt())


            }
            if (editText32.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 2, editText32.text.toString().toInt())


            }
            if (editText33.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 3, editText33.text.toString().toInt())


            }
            if (editText34.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 4, editText34.text.toString().toInt())


            }
            if (editText35.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 5, editText35.text.toString().toInt())


            }
            if (editText36.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 6, editText36.text.toString().toInt())


            }
            if (editText37.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 7, editText37.text.toString().toInt())


            }
            if (editText38.text.trim().isNotEmpty()) {
                viewModel.setCell(3, 8, editText38.text.toString().toInt())


            }
            if (editText40.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 0, editText40.text.toString().toInt())


            }
            if (editText41.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 1, editText41.text.toString().toInt())


            }
            if (editText42.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 2, editText42.text.toString().toInt())


            }
            if (editText43.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 3, editText43.text.toString().toInt())


            }
            if (editText44.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 4, editText44.text.toString().toInt())


            }
            if (editText45.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 5, editText45.text.toString().toInt())


            }
            if (editText46.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 6, editText46.text.toString().toInt())


            }
            if (editText47.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 7, editText47.text.toString().toInt())


            }
            if (editText48.text.trim().isNotEmpty()) {
                viewModel.setCell(4, 8, editText48.text.toString().toInt())


            }
            if (editText50.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 0, editText50.text.toString().toInt())


            }
            if (editText51.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 1, editText51.text.toString().toInt())


            }
            if (editText52.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 2, editText52.text.toString().toInt())


            }
            if (editText53.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 3, editText53.text.toString().toInt())


            }
            if (editText54.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 4, editText54.text.toString().toInt())


            }
            if (editText55.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 5, editText55.text.toString().toInt())


            }
            if (editText56.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 6, editText56.text.toString().toInt())


            }
            if (editText57.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 7, editText57.text.toString().toInt())


            }
            if (editText58.text.trim().isNotEmpty()) {
                viewModel.setCell(5, 8, editText58.text.toString().toInt())


            }
            if (editText60.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 0, editText60.text.toString().toInt())


            }
            if (editText61.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 1, editText61.text.toString().toInt())


            }
            if (editText62.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 2, editText62.text.toString().toInt())


            }
            if (editText63.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 3, editText63.text.toString().toInt())


            }
            if (editText64.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 4, editText64.text.toString().toInt())


            }
            if (editText65.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 5, editText65.text.toString().toInt())


            }
            if (editText66.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 6, editText66.text.toString().toInt())


            }
            if (editText67.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 7, editText67.text.toString().toInt())


            }
            if (editText68.text.trim().isNotEmpty()) {
                viewModel.setCell(6, 8, editText68.text.toString().toInt())


            }
            if (editText70.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 0, editText70.text.toString().toInt())


            }
            if (editText71.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 1, editText71.text.toString().toInt())


            }
            if (editText72.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 2, editText72.text.toString().toInt())


            }
            if (editText73.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 3, editText73.text.toString().toInt())


            }
            if (editText74.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 4, editText74.text.toString().toInt())


            }
            if (editText75.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 5, editText75.text.toString().toInt())


            }
            if (editText76.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 6, editText76.text.toString().toInt())


            }
            if (editText77.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 7, editText77.text.toString().toInt())


            }
            if (editText78.text.trim().isNotEmpty()) {
                viewModel.setCell(7, 8, editText78.text.toString().toInt())


            }
            if (editText80.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 0, editText80.text.toString().toInt())


            }
            if (editText81.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 1, editText81.text.toString().toInt())


            }
            if (editText82.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 2, editText82.text.toString().toInt())


            }
            if (editText83.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 3, editText83.text.toString().toInt())


            }
            if (editText84.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 4, editText84.text.toString().toInt())


            }
            if (editText85.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 5, editText85.text.toString().toInt())


            }
            if (editText86.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 6, editText86.text.toString().toInt())


            }
            if (editText87.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 7, editText87.text.toString().toInt())


            }
            if (editText88.text.trim().isNotEmpty()) {
                viewModel.setCell(8, 8, editText88.text.toString().toInt())


            }

        }
    }
}


