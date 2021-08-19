package com.example.avd160418066week2tugas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var n1=(0..100).random()
        var n2=(0..100).random()
        var score=0
        txtSoal.text="$n1 + $n2"
        btnSubmit.setOnClickListener {
            if(txtJawaban.text.toString().toInt()==(n1+n2)){
                n1=(0..100).random()
                n2=(0..100).random()
                score=score+1
                txtSoal.text="$n1 + $n2"
                txtJawaban.setText("")
            }
            else{
                val act=MainFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(act)
            }
        }
    }

}