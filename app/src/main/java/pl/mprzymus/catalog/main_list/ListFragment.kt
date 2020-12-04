package pl.mprzymus.catalog.main_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.model.Record

class ListFragment : Fragment() {
    lateinit var viewModel: CatalogViewModel
    private lateinit var viewAdapter: RecordAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.wtf("NAv", "Was he right?")
        viewModel = ViewModelProvider(requireActivity()).get(CatalogViewModel::class.java)
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter = RecordAdapter(
            viewModel.records,
            RecordClickListener(viewModel) { onRecordClick() },
            ColorProvider.getSecondaryColor(requireContext(), resources)
        )
        val act = activity
        if (act != null) {
            recyclerView = rootView.findViewById<RecyclerView>(R.id.data_recycle).apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        val filter = rootView.findViewById<SearchView>(R.id.category_filter)
        filter.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewAdapter.filter.filter(newText)
                return false
            }

        })
        viewModel.favourites.observe(viewLifecycleOwner,
            { shouldShowAll ->
                viewAdapter.switchFavouriteShow(
                    shouldShowAll,
                    filter.query.toString()
                )
            })
        val favouritesButton = rootView.findViewById<CheckBox>(R.id.favourite)
        favouritesButton.setOnClickListener { viewModel.switchFavourites() }
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(viewAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
        return rootView
    }

    private fun onRecordClick() {
        Log.d(
            "Click",
            "List fragment will show record details ${viewModel.toShow.value!!.name}"
        )
        Navigation.findNavController(requireView()).navigate(R.id.toDescription)
    }
}
