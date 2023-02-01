package com.assign3maulana.app.room.di

import androidx.lifecycle.ViewModelProvider
import com.assign3maulana.app.room.vmfactory.StudentViewModelFactory

/**
 * Created by maulana kavaldo on 15/12/2020.
 */
abstract class ViewModelFactoryModule {


    internal abstract fun bindViewModelFactory(vMFactory : StudentViewModelFactory) : ViewModelProvider.Factory
}