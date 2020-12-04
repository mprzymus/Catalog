package pl.mprzymus.catalog.main_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R

class ListFragment : Fragment() {
    private lateinit var viewModel: CatalogViewModel
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
            viewModel.records.value!!,
            RecordClickListener(viewModel),
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
        viewModel.toShow.observe(viewLifecycleOwner, {onRecordClick(rootView)})
        val favouritesButton = rootView.findViewById<CheckBox>(R.id.favourite)
        favouritesButton.setOnClickListener { viewModel.switchFavourites() }
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(viewAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
        return rootView
    }

    private fun onRecordClick(view: View) {
        if (viewModel.toShow.value != null) {
            Log.d("Click", "List fragment will show record details ${viewModel.toShow.value!!.name}")
            Navigation.findNavController(view).navigate(R.id.toDescription)
        }
    }
}
