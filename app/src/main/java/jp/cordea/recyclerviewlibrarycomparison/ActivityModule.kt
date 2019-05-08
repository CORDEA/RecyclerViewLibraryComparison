package jp.cordea.recyclerviewlibrarycomparison

import dagger.Module
import jp.cordea.recyclerviewlibrarycomparison.bento.BentoActivityModule
import jp.cordea.recyclerviewlibrarycomparison.epoxy.EpoxyActivityModule
import jp.cordea.recyclerviewlibrarycomparison.graywater.GraywaterActivityModule
import jp.cordea.recyclerviewlibrarycomparison.groupie.GroupieActivityModule
import jp.cordea.recyclerviewlibrarycomparison.klaster.KlasterActivityModule

@Module(
    includes = [
        MainActivityModule::class,
        GroupieActivityModule::class,
        KlasterActivityModule::class,
        EpoxyActivityModule::class,
        GraywaterActivityModule::class,
        BentoActivityModule::class
    ]
)
class ActivityModule
