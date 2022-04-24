package com.royalboe.bakingtutorial.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.royalboe.bakingtutorial.databinding.FragmentFirstBinding
import com.royalboe.bakingtutorial.network.Recipe

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecipeListFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: RecipeListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset:List<Recipe> = viewModel.recipe.value!!
        binding.recipeListRecyclerView.adapter = RecipeListAdapter(viewModel, dataset)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}