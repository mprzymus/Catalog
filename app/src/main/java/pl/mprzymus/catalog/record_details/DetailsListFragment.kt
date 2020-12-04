package pl.mprzymus.catalog.record_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.mprzymus.catalog.CatalogViewModel
import pl.mprzymus.catalog.databinding.FragmentDetailsListBinding

class DetailsListFragment : Fragment() {

    private lateinit var viewModel: CatalogViewModel
    private lateinit var binding: FragmentDetailsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(CatalogViewModel::class.java)
        binding = FragmentDetailsListBinding.inflate(layoutInflater)
        binding.detailsContent.text = createStringForDetails()
        return binding.root
    }

    private fun createStringForDetails(): String {
        val record = viewModel.toShow.value
        return record?.links?.joinToString("\n") ?: ""
    }
}