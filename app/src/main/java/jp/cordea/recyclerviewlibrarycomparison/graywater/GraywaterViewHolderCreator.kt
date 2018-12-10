package jp.cordea.recyclerviewlibrarycomparison.graywater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tumblr.graywater.GraywaterAdapter
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ListItemGraywaterBinding
import javax.inject.Inject

class GraywaterViewHolderCreator @Inject constructor() : GraywaterAdapter.ViewHolderCreator {
    override fun getViewType(): Int = R.layout.list_item_graywater

    override fun create(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(ListItemGraywaterBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    class ViewHolder(val binding: ListItemGraywaterBinding) : RecyclerView.ViewHolder(binding.root)
}
