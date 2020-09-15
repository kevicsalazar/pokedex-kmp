package com.kevicsalazar.pokedex.androidApp.utils

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.direct
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.on

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : DIAware, T : FragmentActivity {
    return viewModels(factoryProducer = { direct.instance() })
}

inline fun <reified VM : ViewModel, T> T.activityScopedFragmentViewModel(): Lazy<VM> where T : DIAware, T : Fragment {
    return viewModels(ownerProducer = { requireParentFragment() },
        factoryProducer = { getFactoryInstance() })
}

inline fun <reified VM : ViewModel, T> T.fragmentViewModel(): Lazy<VM> where T : DIAware, T : Fragment {
    return viewModels(factoryProducer = { getFactoryInstance() })
}

inline fun <reified VM : ViewModel> DI.Builder.bindViewModel(overrides: Boolean? = null): DI.Builder.TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, overrides)
}

fun <T> T.getFactoryInstance(): ViewModelProvider.Factory where T : DIAware, T : Fragment {
    val viewModeFactory: ViewModelProvider.Factory by di.on(requireContext()).instance()
    return viewModeFactory
}