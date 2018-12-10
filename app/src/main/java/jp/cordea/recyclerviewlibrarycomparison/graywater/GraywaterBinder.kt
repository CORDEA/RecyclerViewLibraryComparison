package jp.cordea.recyclerviewlibrarycomparison.graywater

import com.tumblr.graywater.GraywaterAdapter
import jp.cordea.recyclerviewlibrarycomparison.R
import javax.inject.Inject
import javax.inject.Provider

class GraywaterBinder @Inject constructor() :
    GraywaterAdapter.Binder<GraywaterItemModel, GraywaterViewHolderCreator.ViewHolder, GraywaterViewHolderCreator.ViewHolder> {
    override fun prepare(
        model: GraywaterItemModel,
        binderList: MutableList<Provider<GraywaterAdapter.Binder<in GraywaterItemModel, GraywaterViewHolderCreator.ViewHolder, out GraywaterViewHolderCreator.ViewHolder>>>?,
        binderIndex: Int
    ) {
    }

    override fun bind(
        model: GraywaterItemModel,
        holder: GraywaterViewHolderCreator.ViewHolder,
        binderList: MutableList<Provider<GraywaterAdapter.Binder<in GraywaterItemModel, GraywaterViewHolderCreator.ViewHolder, out GraywaterViewHolderCreator.ViewHolder>>>,
        binderIndex: Int,
        actionListener: GraywaterAdapter.ActionListener<GraywaterItemModel, GraywaterViewHolderCreator.ViewHolder, GraywaterViewHolderCreator.ViewHolder>?
    ) {
        holder.binding.model = model
    }

    override fun getViewType(model: GraywaterItemModel?): Int = R.layout.list_item_graywater

    override fun unbind(holder: GraywaterViewHolderCreator.ViewHolder) {
    }
}
