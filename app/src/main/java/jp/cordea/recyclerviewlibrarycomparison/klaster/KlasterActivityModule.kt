package jp.cordea.recyclerviewlibrarycomparison.klaster

import android.app.Activity
import android.view.LayoutInflater
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface KlasterActivityModule {
    @ContributesAndroidInjector(
        modules = [
            KlasterActivityBindModule::class
        ]
    )
    fun contributeKlasterActivity(): KlasterActivity
}

@Module
abstract class KlasterActivityBindModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideLayoutInflater(activity: KlasterActivity): LayoutInflater = activity.layoutInflater
    }

    @Binds
    abstract fun bindActivity(activity: KlasterActivity): Activity
}
