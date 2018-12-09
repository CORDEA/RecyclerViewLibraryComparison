package jp.cordea.recyclerviewlibrarycomparison.klaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import jp.cordea.recyclerviewlibrarycomparison.MainRepository
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityKlasterBinding
import javax.inject.Inject

class KlasterActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: MainRepository

    @Inject
    lateinit var binder: KlasterAdapterBinder

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityKlasterBinding>(this, R.layout.activity_klaster)
        binding.recyclerView.adapter = binder.adapter

        disposable = repository.getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ langs ->
                binder.update(langs.map { KlasterItemModel.from(it) })
            }, { })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
