package jp.cordea.recyclerviewlibrarycomparison

import android.app.Activity
import android.content.Intent
import jp.cordea.recyclerviewlibrarycomparison.groupie.GroupieActivity
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val activity: Activity
) {
    fun navigateToGroupie() {
        activity.startActivity(Intent(activity, GroupieActivity::class.java))
    }
}
