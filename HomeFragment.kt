package com.example.apicalls.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.apicalls.MainViewModel
import com.example.apicalls.adapter.GotAdapter
import com.example.apicalls.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val gotAdapter = GotAdapter()
            binding.gotRecycler.adapter = gotAdapter

            viewModel.characters.observe(viewLifecycleOwner){
                gotAdapter.submitList(it)
            }

    }
}
