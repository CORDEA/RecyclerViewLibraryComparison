package jp.cordea.recyclerviewlibrarycomparison.epoxy

import androidx.core.net.toUri
import jp.cordea.recyclerviewlibrarycomparison.Language

class EpoxyItemModel(
    val title: String,
    val description: String,
    url: String
) {
    companion object {
        fun from(language: Language) =
            EpoxyItemModel(language.name, language.designers.joinToString(", "), language.url)
    }

    val uri = url.toUri()
}
