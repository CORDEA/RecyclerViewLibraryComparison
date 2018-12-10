package jp.cordea.recyclerviewlibrarycomparison

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import jp.cordea.recyclerviewlibrarycomparison.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: MainNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.groupieButton.setOnClickListener { navigator.navigateToGroupie() }
        binding.klasterButton.setOnClickListener { navigator.navigateToKlaster() }
        binding.epoxyButton.setOnClickListener { navigator.navigateToEpoxy() }
        binding.graywaterButton.setOnClickListener { navigator.navigateToGraywater() }
    }
}
