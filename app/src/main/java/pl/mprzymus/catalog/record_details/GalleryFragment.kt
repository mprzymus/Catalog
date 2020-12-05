package pl.mprzymus.catalog.record_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.databinding.FragmentDescriptionBinding
import pl.mprzymus.catalog.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var viewAdapter: GalleryRecycleAdapter
    private lateinit var binding: FragmentGalleryBinding
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(requireActivity()).get(CatalogViewModel::class.java)
        val viewManager = GridLayoutManager(context, 2)
        viewAdapter = GalleryRecycleAdapter(viewModel.toShow.value!!.otherImages)
        recyclerView = binding.dataRecycle.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return binding.root
    }
}