package com.example.alcantara_exer5_lightsoutv2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.alcantara_exer5_lightsoutv2.databinding.FragmentCongratsBinding

/**
 * A simple [Fragment] subclass.
 */
class CongratsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCongratsBinding>(inflater,
            R.layout.fragment_congrats,container,false)

        binding.restartButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_congratsFragment_to_startFragment)
        }
        return binding.root
    }


}
