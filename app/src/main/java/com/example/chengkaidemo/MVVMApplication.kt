package com.example.chengkaidemo

import android.app.Application
import com.example.chengkaidemo.data.db.AppDatabase
import com.example.chengkaidemo.data.network.MyApi
import com.example.chengkaidemo.data.network.NetworkConnectionInterceptor
import com.example.chengkaidemo.data.repositories.UserRepository
import com.example.chengkaidemo.ui.auth.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
class MVVMApplication : Application(), KodeinAware{

    override val kodein = Kodein.lazy{
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
    }

}