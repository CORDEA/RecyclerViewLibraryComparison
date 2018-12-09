package jp.cordea.recyclerviewlibrarycomparison.epoxy

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import jp.cordea.recyclerviewlibrarycomparison.ListItemNavigator
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityEpoxyBinding
import jp.cordea.recyclerviewlibrarycomparison.listItem
import javax.inject.Inject

class EpoxyActivityUiBinder private constructor(
    private val navigator: ListItemNavigator,
    private val binding: ActivityEpoxyBinding
) {
    class Factory @Inject constructor(
        private val navigator: ListItemNavigator
    ) {
        fun create(binding: ActivityEpoxyBinding) = EpoxyActivityUiBinder(navigator, binding)
    }

    fun bind(models: List<EpoxyItemModel>) {
        binding.recyclerView.clear()
        binding.recyclerView.withModels(models)
    }

    private fun EpoxyRecyclerView.withModels(models: List<EpoxyItemModel>) {
        setControllerAndBuildModels(object : EpoxyController() {
            override fun buildModels() {
                models.forEach { model ->
                    listItem {
                        id(model.hashCode())
                        title(model.title)
                        description(model.description)
                    }
                }
            }
        })
    }
}
