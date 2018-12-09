package jp.cordea.recyclerviewlibrarycomparison.groupie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import jp.cordea.recyclerviewlibrarycomparison.MainRepository
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityGroupieBinding
import javax.inject.Inject

class GroupieActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: GroupieAdapter

    @Inject
    lateinit var repository: MainRepository

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityGroupieBinding>(this, R.layout.activity_groupie)
        binding.recyclerView.adapter = adapter

        disposable = repository.getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ langs ->
                adapter.update(langs.map { GroupieItemModel.from(it) })
            }, {
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
