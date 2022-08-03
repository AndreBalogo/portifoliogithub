package br.com.andrebalogo.portifoliogithub.repositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.andrebalogo.portifoliogithub.R
import br.com.andrebalogo.portifoliogithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //TODO bindar actionbar
    }
}