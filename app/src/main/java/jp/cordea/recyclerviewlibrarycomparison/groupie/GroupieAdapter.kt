package jp.cordea.recyclerviewlibrarycomparison.groupie

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject

class GroupieAdapter @Inject constructor(
    private val factory: GroupieItem.Factory
) : GroupAdapter<ViewHolder>() {
    fun update(models: List<GroupieItemModel>) = addAll(models.map { factory.create(it) })
}
