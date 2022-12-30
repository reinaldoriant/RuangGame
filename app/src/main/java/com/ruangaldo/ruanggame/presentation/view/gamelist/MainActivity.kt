package com.ruangaldo.ruanggame.presentation.view.gamelist

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ruangaldo.ruanggame.databinding.ActivityMainBinding
import com.ruangaldo.ruanggame.presentation.adapter.GameListAdapter
import com.ruangaldo.ruanggame.presentation.base.BaseActivity
import com.ruangaldo.ruanggame.util.extension.ViewExtension.gone
import com.ruangaldo.ruanggame.util.extension.ViewExtension.hideLoading
import com.ruangaldo.ruanggame.util.extension.ViewExtension.visible
import com.ruangaldo.ruanggame.util.extension.subscribe
import com.ruangaldo.ruanggame.util.view.Constant
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var _adapter: GameListAdapter

    private val _viewModel: GameListViewModel by viewModels()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        initView()
        initialize()
        subscribeViewModel()
        initializeView()
    }

    private fun initView() {
        binding.swipeRefresh.setOnRefreshListener(this)
    }

    private fun fetchGame() {
        _viewModel.fetchGame(binding.swipeRefresh.isRefreshing, isNetworkAvailable(this))
    }

    override fun initialize() {
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
                    binding.clLoading.root.visible()
                },
                doOnSuccess = {
                    binding.clLoading.root.gone()
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

    override fun onRefresh() {
        fetchGame()
        binding.swipeRefresh.hideLoading()
    }

    override fun onResume() {
        super.onResume()
        fetchGame()
    }
}
