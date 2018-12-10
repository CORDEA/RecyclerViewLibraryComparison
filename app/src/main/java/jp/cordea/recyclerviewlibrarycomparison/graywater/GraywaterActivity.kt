package jp.cordea.recyclerviewlibrarycomparison.graywater

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import jp.cordea.recyclerviewlibrarycomparison.MainRepository
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityGraywaterBinding
import javax.inject.Inject

class GraywaterActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: MainRepository

    @Inject
    lateinit var adapter: GraywaterAdapter

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityGraywaterBinding>(this, R.layout.activity_graywater)
        binding.recyclerView.adapter = adapter

        disposable = repository
            .getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ langs ->
                langs.forEach { adapter.add(GraywaterItemModel.from(it)) }
            }, { })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
