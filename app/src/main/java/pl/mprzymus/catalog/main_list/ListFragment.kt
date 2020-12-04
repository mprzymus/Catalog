package pl.mprzymus.catalog.main_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R

class ListFragment : Fragment() {
    private val viewModel: CatalogViewModel by activityViewModels()
    private lateinit var viewAdapter: RecordAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter = RecordAdapter(viewModel.records.value!!)
        val act = activity
        if (act != null) {
            recyclerView = rootView.findViewById<RecyclerView>(R.id.data_recycle).apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
        val filter = rootView.findViewById<SearchView>(R.id.category_filter)
        filter.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewAdapter.filter.filter(newText)
                return false
            }

        })
        viewModel.favourites.observe(viewLifecycleOwner,
        { shouldShowAll -> viewAdapter.switchFavouriteShow(shouldShowAll, filter.query.toString())})
        val favouritesButton = rootView.findViewById<CheckBox>(R.id.favourite)
        favouritesButton.setOnClickListener { viewModel.switchFavourites() }
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(viewAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
        return rootView
    }
}
