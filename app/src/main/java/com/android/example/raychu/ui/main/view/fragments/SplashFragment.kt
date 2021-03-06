package com.android.example.raychu.ui.main.view.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.raychu.R


class SplashFragment : Fragment() {

    companion object {
        private const val DELAY: Long = 1500
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
        Handler().postDelayed({
            context?.let {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }, DELAY)
    }
}
