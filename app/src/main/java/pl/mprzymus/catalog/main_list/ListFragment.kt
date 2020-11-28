package pl.mprzymus.catalog.main_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.R

class ListFragment : Fragment() {
    private lateinit var viewAdapter: RecordAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val bootstrap = Bootstrap()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        viewManager = LinearLayoutManager(context)
        val data = bootstrap.data
        viewAdapter = RecordAdapter(data)
        val act = activity
        if (act != null) {
            recyclerView = rootView.findViewById<RecyclerView>(R.id.data_recycle).apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }

        return rootView
    }
}