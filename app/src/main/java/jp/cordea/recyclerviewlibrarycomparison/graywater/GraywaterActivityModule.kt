package jp.cordea.recyclerviewlibrarycomparison.graywater

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface GraywaterActivityModule {
    @ContributesAndroidInjector(
        modules = [
            GraywaterActivityBindModule::class
        ]
    )
    fun contributeGraywaterActivity(): GraywaterActivity
}

@Module
interface GraywaterActivityBindModule {
    @Binds
    fun bindActivity(activity: GraywaterActivity): Activity
}
