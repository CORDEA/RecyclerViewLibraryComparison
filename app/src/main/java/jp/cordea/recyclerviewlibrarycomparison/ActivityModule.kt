package jp.cordea.recyclerviewlibrarycomparison

import dagger.Module
import jp.cordea.recyclerviewlibrarycomparison.groupie.GroupieActivityModule

@Module(
    includes = [
        MainActivityModule::class,
        GroupieActivityModule::class
    ]
)
class ActivityModule
