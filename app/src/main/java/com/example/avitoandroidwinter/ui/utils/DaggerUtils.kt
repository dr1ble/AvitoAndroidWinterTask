package com.example.avitoandroidwinter.ui.utils

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.avitoandroidwinter.MainActivity

fun Fragment.getComponent() = (requireActivity() as MainActivity).activityComponent

@MainThread
inline fun <reified VM : ViewModel> Fragment.daggerViewModel(
): Lazy<VM> {
    return viewModels<VM> { getComponent().getViewModelFactory() }
}