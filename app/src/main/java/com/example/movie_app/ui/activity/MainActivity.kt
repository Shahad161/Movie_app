package com.example.movie_app.ui.activity

import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.movie_app.R
import com.example.movie_app.databinding.ActivityMainBinding
import com.example.movie_app.ui.base.BaseActivity
import com.example.movie_app.utils.setVisibility


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutID() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        binding.navigation.setupWithNavController(findNavController(R.id.fragment_host))
    }

    override fun onSupportNavigateUp(): Boolean {
        findNavController(R.id.fragment_host).navigateUp()
        return true
    }

}