package jp.cordea.recyclerviewlibrarycomparison.graywater

import com.tumblr.graywater.GraywaterAdapter
import javax.inject.Inject

class GraywaterAdapter @Inject constructor(
    creator: GraywaterViewHolderCreator,
    itemBinder: GraywaterItemBinder
) :
    GraywaterAdapter<GraywaterItemModel, GraywaterViewHolderCreator.ViewHolder, GraywaterBinder, Class<*>>() {
    init {
        register(creator, GraywaterViewHolderCreator.ViewHolder::class.java)
        register(GraywaterItemModel::class.java, itemBinder, null)
    }

    override fun getModelType(model: GraywaterItemModel): Class<*> = model.javaClass
}
