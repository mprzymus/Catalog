package pl.mprzymus.catalog.record_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.R
import pl.mprzymus.catalog.databinding.FragmentDescriptionBinding
import pl.mprzymus.catalog.model.Record

class DescriptionFragment : Fragment() {
    lateinit var toShow: Record
    lateinit var viewModel: CatalogViewModel
    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity()).get(CatalogViewModel::class.java)
        toShow = viewModel.toShow.value!!
        binding.info.text = toShow.description
        binding.detailsButton.setOnClickListener { onShowLinksClick() }
        binding.galleryButton.setOnClickListener { onShowGalleryClick() }
        return binding.root
    }

    private fun onShowLinksClick() {
        Navigation.findNavController(requireView()).navigate(R.id.toDetails)
    }

    private fun onShowGalleryClick() {
        Navigation.findNavController(requireView()).navigate(R.id.toGallery)
    }
}