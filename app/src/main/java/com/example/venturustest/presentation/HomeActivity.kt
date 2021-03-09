package com.example.venturustest.presentation

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.venturustest.AppManager
import com.example.venturustest.R
import com.example.venturustest.extensions.setVisible

class HomeActivity : AppCompatActivity() {

    private val viewModel = AppManager.createViewModel()
    private val adapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<RecyclerView>(R.id.rv_gallery).apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@HomeActivity,
                spanCountWitOrientation(this@HomeActivity.resources.configuration.orientation))
            adapter = this@HomeActivity.adapter
        }

        findViewById<ImageButton>(R.id.ib_try_again).setOnClickListener {
            viewModel.getGallery()
        }

        viewModel.showLoadingLiveData.observe( this, { isLoading ->
            findViewById<ProgressBar>(R.id.progress_bar).setVisible(isLoading)
        })

        viewModel.showErrorLiveData.observe(this, { isError ->
            findViewById<Group>(R.id.group_home_error).setVisible(isError)
        })

        viewModel.itemsGalleryLiveData.observe(this, { items ->
            adapter.setData(items)
        })

        viewModel.getGallery()
    }

    private fun spanCountWitOrientation(orientation: Int): Int {
        return when(orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> 2
            else -> 1
        }
    }
}