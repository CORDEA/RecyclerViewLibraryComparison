package jp.cordea.recyclerviewlibrarycomparison.bento

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.yelp.android.bento.componentcontrollers.RecyclerViewComponentController
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import jp.cordea.recyclerviewlibrarycomparison.MainRepository
import jp.cordea.recyclerviewlibrarycomparison.R
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityBentoBinding
import javax.inject.Inject

class BentoActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: MainRepository

    @Inject
    lateinit var componentFactory: BentoComponent.Factory

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityBentoBinding>(this, R.layout.activity_bento)
        val controller = RecyclerViewComponentController(binding.recyclerView)

        disposable = repository.getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ langs ->
                controller.clear()
                controller.addAll(langs.map { componentFactory.create(BentoComponentModel.from(it)) })
            }, {
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
