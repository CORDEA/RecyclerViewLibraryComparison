package jp.cordea.recyclerviewlibrarycomparison.epoxy

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface EpoxyActivityModule {
    @ContributesAndroidInjector(
        modules = [
            EpoxyActivityBindModule::class
        ]
    )
    fun contributeEpoxyActivity(): EpoxyActivity
}

@Module
interface EpoxyActivityBindModule {
    @Binds
    fun bindActivity(activity: EpoxyActivity): Activity
}
