package com.example.alcantara_exer5_lightsoutv2


import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.alcantara_exer5_lightsoutv2.databinding.FragmentGameBinding


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private val cellIDs1: Array<TextView> = arrayOf(binding.cell1,binding.cell2,binding.cell3,binding.cell4,binding.cell5)
    private val cellIDs2: Array<TextView> = arrayOf(binding.cell6,binding.cell7,binding.cell8,binding.cell9,binding.cell10)
    private val cellIDs3: Array<TextView> = arrayOf(binding.cell11,binding.cell12,binding.cell13,binding.cell14,binding.cell15)
    private val cellIDs4: Array<TextView> = arrayOf(binding.cell16,binding.cell17,binding.cell18,binding.cell19,binding.cell20)
    private val cellIDs5: Array<TextView> = arrayOf(binding.cell21,binding.cell22,binding.cell23,binding.cell24,binding.cell25)
    private val cellIDs: Array<Array<TextView>> = arrayOf(cellIDs1, cellIDs2, cellIDs3, cellIDs4, cellIDs5)




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)


        return binding.root
    }





    //@SuppressLint("ServiceCast")


    fun switchColor(view: View) {
        for(i in 0..4){
            for(j in 0..4){
                if(view.id==cellIDs[i][j].id) {
                    changeColor(cellIDs[i][j])
                    try {
                        changeColor(cellIDs[i-1][j])
                    }  catch (e:Exception){}
                    try {
                        changeColor(cellIDs[i+1][j])
                    }  catch (e:Exception){}
                    try {
                        changeColor(cellIDs[i][j+1])
                    }  catch (e:Exception){}
                    try {
                        changeColor(cellIDs[i][j-1])
                    }  catch (e:Exception){}
                    break
                }
            }
        }
        if(checkWin()){

            //NAVIGATE NA LANG====================================================PLUS RESET
            clearColors()
            view.findNavController().navigate(R.id.action_gameFragment_to_congratsFragment)


        }

        var countTxt = Integer.parseInt(binding.movecount.text.toString())
        countTxt++
        val newTxt = countTxt.toString()
        binding.movecount.text = newTxt


    }


    private fun changeColor(view: View){
        val cd = view.background as ColorDrawable
        if (cd.color == Color.WHITE) {
            view.setBackgroundColor(Color.BLUE)
        } else{view.setBackgroundColor(Color.WHITE)}
    }

    private fun checkWin(): Boolean{
        var count = 0
        for(i in 0..4){
            for(j in 0..4){
                val cd = cellIDs[i][j].background as ColorDrawable
                if(cd.color == Color.BLUE) count++
            }
        }
        return(count==25)
    }



    private fun clearColors() {
        for(i in 0..4){
            for(j in 0..4){
                cellIDs[i][j].setBackgroundColor(Color.WHITE)
            }
        }
        binding.movecount.text = "0"
    }
}
