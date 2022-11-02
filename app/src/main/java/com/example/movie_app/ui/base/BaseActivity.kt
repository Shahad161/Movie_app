package com.example.movie_app.ui.base

import android.os.Bundle
import androidx.annotation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.*
import com.example.movie_app.BR


abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayoutID(): Int

    private lateinit var _binding: VDB
    protected val binding get() = _binding

    protected abstract val viewModel: BaseViewModel
    protected open val viewModelBindingVariable get() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView<VDB>(this, getLayoutID()).apply {
            setVariable(viewModelBindingVariable, viewModel)
            lifecycleOwner = this@BaseActivity
        }
    }

}
