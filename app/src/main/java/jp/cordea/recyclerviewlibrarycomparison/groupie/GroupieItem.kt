package jp.cordea.recyclerviewlibrarycomparison.groupie

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.recyclerviewlibrarycomparison.Language
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ListItemGroupieBinding
import javax.inject.Inject

class GroupieItemModel(
    val title: String,
    val description: String,
    val url: String
) {
    companion object {
        fun from(language: Language) =
            GroupieItemModel(language.name, language.designers.joinToString(", "), language.url)
    }
}

class GroupieItem private constructor(
    private val model: GroupieItemModel
) : BindableItem<ListItemGroupieBinding>() {
    class Factory @Inject constructor() {
        fun create(model: GroupieItemModel) = GroupieItem(model)
    }

    override fun getLayout(): Int = R.layout.list_item_groupie

    override fun bind(viewBinding: ListItemGroupieBinding, position: Int) {
        viewBinding.model = model
        viewBinding.root.setOnClickListener { }
    }
}
