package jp.cordea.recyclerviewlibrarycomparison.klaster

import android.view.LayoutInflater
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.github.rongi.klaster.Klaster
import jp.cordea.recyclerviewlibrarycomparison.Language
import jp.cordea.recyclerviewlibrarycomparison.ListItemNavigator
import jp.cordea.recyclerviewlibrarycomparison.databinding.ListItemKlasterBinding
import javax.inject.Inject

class KlasterItemModel(
    val title: String,
    val description: String,
    url: String
) {
    companion object {
        fun from(language: Language) =
            KlasterItemModel(language.name, language.designers.joinToString(", "), language.url)
    }

    val uri = url.toUri()
}

class KlasterAdapterBinder @Inject constructor(
    private val layoutInflater: LayoutInflater,
    private val navigator: ListItemNavigator
) {
    private var models: List<KlasterItemModel> = emptyList()

    val adapter = Klaster.withViewHolder<ViewHolder>()
        .itemCount { models.size }
        .viewHolder { _, parent -> ViewHolder(ListItemKlasterBinding.inflate(layoutInflater, parent, false)) }
        .bind { position ->
            val model = models[position]
            binding.model = model
            binding.root.setOnClickListener { navigator.navigateToWeb(model.uri) }
        }
        .build()

    fun update(models: List<KlasterItemModel>) {
        this.models = models
        adapter.notifyDataSetChanged()
    }

    private class ViewHolder(val binding: ListItemKlasterBinding) : RecyclerView.ViewHolder(binding.root)
}
