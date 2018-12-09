package jp.cordea.recyclerviewlibrarycomparison

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivityBindModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
interface MainActivityBindModule {
    @Binds
    fun bindActivity(activity: MainActivity): Activity
}
