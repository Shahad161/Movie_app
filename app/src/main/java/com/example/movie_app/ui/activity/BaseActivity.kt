package com.example.movie_app.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    abstract val Log_tag: String
    abstract val bindingInflater: (LayoutInflater) -> VB
    abstract var _binding: ViewBinding
    protected var binding: VB?
        get() = _binding as VB
        set(value) = TODO()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        _binding = bindingInflater(layoutInflater)
        setContentView(_binding.root)
        super.onCreate(savedInstanceState)

    }

    protected fun log(value: Any){
        Log.v(Log_tag, value.toString())
    }

}