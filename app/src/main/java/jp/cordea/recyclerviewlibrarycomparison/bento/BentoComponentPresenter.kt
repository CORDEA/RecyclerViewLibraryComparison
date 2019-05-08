package jp.cordea.recyclerviewlibrarycomparison.bento

import android.net.Uri
import jp.cordea.recyclerviewlibrarycomparison.ListItemNavigator
import javax.inject.Inject

class BentoComponentPresenter @Inject constructor(
    private val navigator: ListItemNavigator
) {
    fun openUrl(uri: Uri) {
        navigator.navigateToWeb(uri)
    }
}
