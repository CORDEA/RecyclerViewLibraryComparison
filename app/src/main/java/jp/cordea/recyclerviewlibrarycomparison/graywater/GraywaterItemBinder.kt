package jp.cordea.recyclerviewlibrarycomparison.graywater

import com.tumblr.graywater.GraywaterAdapter
import javax.inject.Inject
import javax.inject.Provider

class GraywaterItemBinder @Inject constructor(
    private val binder: Provider<GraywaterBinder>
) : GraywaterAdapter.ItemBinder<GraywaterItemModel, GraywaterViewHolderCreator.ViewHolder, GraywaterBinder> {
    override fun getBinderList(model: GraywaterItemModel, position: Int): List<Provider<out GraywaterBinder>> =
        listOf(binder)
}
