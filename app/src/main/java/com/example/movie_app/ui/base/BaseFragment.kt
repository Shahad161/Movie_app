package com.example.movie_app.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.movie_app.databinding.FragmentActorBinding
import com.example.movie_app.ui.PopularPersonAdapter
import com.example.movie_app.ui.fagment.ActorFragmentDirections

abstract class BaseFragment <VB : ViewBinding> : Fragment(){
    protected lateinit var binding: VB
    protected abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addCallBack()
        return binding.root
    }
    private fun init() {
        binding = getViewBinding()
        setUpViews()
    }
    open fun setUpViews() {}
    abstract fun addCallBack()
}