package com.android.example.raychu.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.example.raychu.R
import kotlinx.android.synthetic.main.fragment_dog_detail.*

class DogDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        val args = DogDetailFragmentArgs.fromBundle(arguments!!)
        var bredFor = if(args?.bredFor == null) "Not Available" else args?.bredFor
        bred_for.setText(bredFor)
        var breedGroupValue = if(args?.breedGroup == null) "Not Available" else args?.breedGroup
        breed_group.setText(breedGroupValue)
        var descriptionValue = if(args?.description == null) "Not Available" else args?.description
        description.setText(descriptionValue)
        var temperamentValue = if(args?.temperament == null) "Not Available" else args?.temperament
        temperament.setText(temperamentValue)
    }

}
