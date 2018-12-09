package jp.cordea.recyclerviewlibrarycomparison.groupie

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface GroupieActivityModule {
    @ContributesAndroidInjector
    fun contributeGroupieActivity(): GroupieActivity
}
