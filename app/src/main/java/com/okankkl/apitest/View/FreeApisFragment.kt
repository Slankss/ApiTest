package com.okankkl.apitest.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.apitest.Adapter.ApiAdapter
import com.okankkl.apitest.Model.API
import com.okankkl.apitest.R
import com.okankkl.apitest.ViewModel.ApiViewModel
import com.okankkl.apitest.databinding.FragmentFreeApisBinding
import retrofit2.Response


class FreeApisFragment : Fragment() {

    private lateinit var binding : FragmentFreeApisBinding
    private val viewModel by lazy { ApiViewModel() }
   private lateinit var apiAdapter : ApiAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFreeApisBinding.inflate(layoutInflater)


        viewModel.apiList.observe(viewLifecycleOwner){ apis ->
            val apiList = apis as ArrayList<API>
            binding.progressBar.visibility = View.GONE

            context?.let {
                val layoutManager = LinearLayoutManager(it)
                binding.apiRecyclerView.layoutManager = layoutManager
                apiAdapter= ApiAdapter(apiList)
                binding.apiRecyclerView.adapter = apiAdapter
            }


        }


        return binding.root
    }



}