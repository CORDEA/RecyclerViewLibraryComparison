package jp.cordea.recyclerviewlibrarycomparison.graywater

import androidx.core.net.toUri
import jp.cordea.recyclerviewlibrarycomparison.Language

class GraywaterItemModel(
    val title: String,
    val description: String,
    url: String
) {
    companion object {
        fun from(language: Language) =
            GraywaterItemModel(language.name, language.designers.joinToString(", "), language.url)
    }

    val uri = url.toUri()
}
