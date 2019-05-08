package jp.cordea.recyclerviewlibrarycomparison.bento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yelp.android.bento.core.ComponentViewHolder
import jp.cordea.recyclerviewlibrarycomparison.databinding.ComponentBentoBinding

class BentoComponentViewHolder : ComponentViewHolder<BentoComponentPresenter, BentoComponentModel>() {
    private lateinit var binding: ComponentBentoBinding

    override fun bind(presenter: BentoComponentPresenter, element: BentoComponentModel) {
        binding.model = element
        binding.root.setOnClickListener { presenter.openUrl(element.uri) }
    }

    override fun inflate(parent: ViewGroup): View =
        ComponentBentoBinding.inflate(LayoutInflater.from(parent.context))
            .also { binding = it }
            .root
}
