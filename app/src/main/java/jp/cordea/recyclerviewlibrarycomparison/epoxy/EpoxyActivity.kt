package jp.cordea.recyclerviewlibrarycomparison.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import jp.cordea.recyclerviewlibrarycomparison.MainRepository
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityEpoxyBinding
import javax.inject.Inject

class EpoxyActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: MainRepository

    @Inject
    lateinit var factory: EpoxyActivityUiBinder.Factory

    private lateinit var uiBinder: EpoxyActivityUiBinder

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityEpoxyBinding>(this, R.layout.activity_epoxy)
        uiBinder = factory.create(binding)

        disposable = repository.getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ langs ->
                uiBinder.bind(langs.map { EpoxyItemModel.from(it) })
            }, { })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
