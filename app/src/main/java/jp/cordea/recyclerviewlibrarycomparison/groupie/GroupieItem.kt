package jp.cordea.recyclerviewlibrarycomparison.groupie

import androidx.core.net.toUri
import com.xwray.groupie.databinding.BindableItem
import jp.cordea.recyclerviewlibrarycomparison.Language
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ListItemGroupieBinding
import javax.inject.Inject

class GroupieItemModel(
    val title: String,
    val description: String,
    url: String
) {
    companion object {
        fun from(language: Language) =
            GroupieItemModel(language.name, language.designers.joinToString(", "), language.url)
    }

    val uri = url.toUri()
}

class GroupieItem private constructor(
    private val navigator: GroupieNavigator,
    private val model: GroupieItemModel
) : BindableItem<ListItemGroupieBinding>() {
    class Factory @Inject constructor(
        private val navigator: GroupieNavigator
    ) {
        fun create(model: GroupieItemModel) = GroupieItem(navigator, model)
    }

    override fun getLayout(): Int = R.layout.list_item_groupie

    override fun bind(viewBinding: ListItemGroupieBinding, position: Int) {
        viewBinding.model = model
        viewBinding.root.setOnClickListener { navigator.navigateToWeb(model.uri) }
    }
}
