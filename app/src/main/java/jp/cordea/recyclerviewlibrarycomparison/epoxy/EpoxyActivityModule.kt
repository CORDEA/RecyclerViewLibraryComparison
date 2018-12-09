package jp.cordea.recyclerviewlibrarycomparison.epoxy

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface EpoxyActivityModule {
    @ContributesAndroidInjector
    fun contributeEpoxyActivity(): EpoxyActivity
}
