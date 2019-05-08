package jp.cordea.recyclerviewlibrarycomparison.bento

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BentoActivityModule {
    @ContributesAndroidInjector(
        modules = [
            BentoActivityBindModule::class
        ]
    )
    fun contributeBentoActivity(): BentoActivity
}

@Module
interface BentoActivityBindModule {
    @Binds
    fun bindActivity(activity: BentoActivity): Activity
}
