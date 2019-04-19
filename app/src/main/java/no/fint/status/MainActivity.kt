package no.fint.status

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = StatusListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        status_view.layoutManager = LinearLayoutManager(this)
        status_view.adapter = adapter


        val viewModel = ViewModelProviders.of(this).get(StatusViewModel::class.java).apply {
            statusRepository = StatusRepository(StatusApi(getString(R.string.fint_api_status_base_url)))
        }

        viewModel.getApiStatus().observe(this, Observer { statusList ->
            adapter.setData(statusList)
        })

        swipe_refresh.setOnRefreshListener {
            adapter.setData(emptyList())
            viewModel.loadStatus()
            swipe_refresh.isRefreshing = false
        }
    }

}
