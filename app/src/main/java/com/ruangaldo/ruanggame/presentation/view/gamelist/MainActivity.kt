package com.ruangaldo.ruanggame.presentation.view.gamelist

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.ruangaldo.ruanggame.databinding.ActivityMainBinding
import com.ruangaldo.ruanggame.presentation.adapter.GameListAdapter
import com.ruangaldo.ruanggame.presentation.base.BaseActivity
import com.ruangaldo.ruanggame.util.extension.subscribe
import com.ruangaldo.ruanggame.util.view.Constant
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var _adapter: GameListAdapter

    private val _viewModel: GameListViewModel by viewModels()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        initialize()
        subscribeViewModel()
        initializeView()
    }

    override fun initialize() {
        _viewModel.fetchGame()
        _adapter = GameListAdapter()
        binding.rvContent.adapter = _adapter
    }

    override fun initializeView() {
        binding.tvTitleApp.text = Constant.TITLE
    }
    override fun subscribeViewModel() {
        _viewModel.gameListResult.onLiveDataResult { result ->
            result.subscribe(
                doOnLoading = {
                    binding.clLoading.root.visibility = View.VISIBLE
                },
                doOnSuccess = {
                    binding.clLoading.root.visibility = View.INVISIBLE
                    Timber.d("Data yang masuk ${it.payload?.list}")
                    val data = it.payload?.list
                    _adapter.populatedItem(data ?: emptyList())
                },
                doOnError = {
                    binding.clLoading.root.visibility = View.INVISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            )
        }
    }
}
