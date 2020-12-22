package com.assign3maulana.app.room.di

import androidx.lifecycle.ViewModelProvider
import com.assign3maulana.app.room.vmfactory.StudentViewModelFactory

/**
 * Created by muhrahmatullah on 27/09/18.
 */
abstract class ViewModelFactoryModule {


    internal abstract fun bindViewModelFactory(vMFactory : StudentViewModelFactory) : ViewModelProvider.Factory
}