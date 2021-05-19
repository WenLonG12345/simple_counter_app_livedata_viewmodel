package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = mainViewModel.number.toString()

        binding.button.setOnClickListener {
            mainViewModel.addNumber()
            binding.textView.text = mainViewModel.number.toString()
        }

        // LiveData
        mainViewModel.squareValue.observe(this, {
            binding.tvSquare.text = it.toString()
        })
    }
}