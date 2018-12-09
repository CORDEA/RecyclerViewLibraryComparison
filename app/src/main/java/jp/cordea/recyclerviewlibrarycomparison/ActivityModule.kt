package jp.cordea.recyclerviewlibrarycomparison

import dagger.Module
import jp.cordea.recyclerviewlibrarycomparison.groupie.GroupieActivityModule
import jp.cordea.recyclerviewlibrarycomparison.klaster.KlasterActivityModule

@Module(
    includes = [
        MainActivityModule::class,
        GroupieActivityModule::class,
        KlasterActivityModule::class
    ]
)
class ActivityModule
