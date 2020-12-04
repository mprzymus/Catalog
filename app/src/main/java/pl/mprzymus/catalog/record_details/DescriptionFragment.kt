package pl.mprzymus.catalog.record_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.databinding.FragmentDescriptionBinding
import pl.mprzymus.catalog.model.Record

class DescriptionFragment : Fragment() {
    lateinit var toShow: Record
    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(layoutInflater)
        val rootView = inflater.inflate(R.layout.fragment_description, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(CatalogViewModel::class.java)
        toShow = viewModel.toShow.value!!
        viewModel.resetToShow()
        binding.info.text = toShow.description
        return binding.root
    }

}