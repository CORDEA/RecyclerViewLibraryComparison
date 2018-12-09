package jp.cordea.recyclerviewlibrarycomparison

import android.app.Activity
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class ListItemNavigator @Inject constructor(
    private val activity: Activity
) {
    fun navigateToWeb(uri: Uri) {
        activity.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}
