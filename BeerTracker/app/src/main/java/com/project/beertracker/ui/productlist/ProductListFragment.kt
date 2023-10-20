package com.project.beertracker.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ProductListScreen(
                    navigateUp = { findNavController().navigateUp() },
                    showFilter = ::showFilterDialog,
                    openProductDetails = ::navigateToProductDetail,
                    viewModel = viewModel
                )
            }

        }
    }

    private fun navigateToProductDetail(id: String) {

    }

    private fun showFilterDialog() {
        // Do nothing. Add filter feature later
    }
}