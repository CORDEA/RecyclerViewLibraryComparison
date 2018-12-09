package jp.cordea.recyclerviewlibrarycomparison.groupie

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface GroupieActivityModule {
    @ContributesAndroidInjector(
        modules = [
            GroupieActivityBindModule::class
        ]
    )
    fun contributeGroupieActivity(): GroupieActivity
}

@Module
interface GroupieActivityBindModule {
    @Binds
    fun bindActivity(activity: GroupieActivity): Activity
}
