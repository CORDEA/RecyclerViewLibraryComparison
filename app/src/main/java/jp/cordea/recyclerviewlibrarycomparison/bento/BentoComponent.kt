package jp.cordea.recyclerviewlibrarycomparison.bento

import androidx.core.net.toUri
import com.yelp.android.bento.core.Component
import jp.cordea.recyclerviewlibrarycomparison.Language
import javax.inject.Inject

class BentoComponentModel(
    val title: String,
    val description: String,
    url: String
) {
    companion object {
        fun from(language: Language) =
            BentoComponentModel(language.name, language.designers.joinToString(", "), language.url)
    }

    val uri = url.toUri()
}

class BentoComponent private constructor(
    private val presenter: BentoComponentPresenter,
    private val model: BentoComponentModel
) : Component() {
    class Factory @Inject constructor(
        private val presenter: BentoComponentPresenter
    ) {
        fun create(model: BentoComponentModel) = BentoComponent(presenter, model)
    }

    override fun getPresenter(position: Int) = presenter

    override fun getItem(position: Int) = model

    override fun getCount(): Int = 1

    override fun getHolderType(position: Int) = BentoComponentViewHolder::class.java
}
