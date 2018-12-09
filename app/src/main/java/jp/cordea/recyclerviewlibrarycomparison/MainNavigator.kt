package jp.cordea.recyclerviewlibrarycomparison

import android.app.Activity
import android.content.Intent
import jp.cordea.recyclerviewlibrarycomparison.groupie.GroupieActivity
import jp.cordea.recyclerviewlibrarycomparison.klaster.KlasterActivity
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val activity: Activity
) {
    fun navigateToGroupie() {
        activity.startActivity(Intent(activity, GroupieActivity::class.java))
    }

    fun navigateToKlaster() {
        activity.startActivity(Intent(activity, KlasterActivity::class.java))
    }
}
