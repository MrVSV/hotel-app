package com.vsv.hoteltestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.vsv.core.SetWindow
import com.vsv.hoteltestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SetWindow {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        (supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.topAppBar.setupWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, dest, _ ->
            binding.bottomLayout.isVisible = dest.id != com.vsv.feature_rooms.R.id.roomsFragment
        }
    }

    override fun setUpTitle(title: String) {
        binding.topAppBar.title = title
    }

    override fun setUpBottomButton(buttonText: String, isEnabled: Boolean, action: () -> Unit) {
        with(binding) {
            bigBlueButton.setOnClickListener { action() }
            bigBlueButton.text = buttonText
            bigBlueButton.isEnabled = isEnabled
        }
    }

    override fun setUpProgressBar(isVisible: Boolean) {
        binding.progressBar.visibility = if(isVisible) View.VISIBLE else View.GONE
    }

}