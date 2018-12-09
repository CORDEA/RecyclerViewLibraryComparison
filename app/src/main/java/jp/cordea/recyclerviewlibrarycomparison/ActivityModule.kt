package jp.cordea.recyclerviewlibrarycomparison

import dagger.Module
import jp.cordea.recyclerviewlibrarycomparison.groupie.GroupieActivityModule

@Module(
    includes = [
        GroupieActivityModule::class
    ]
)
class ActivityModule
