package com.example.secondscreen.presentation.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.secondscreen.R
import com.example.secondscreen.databinding.FragmentSecondBinding
import com.example.secondscreen.presentation.adapter.ImagesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private val viewModel by viewModels<SecondViewModel>()

    private val binding by viewBinding(FragmentSecondBinding::bind)

    private val adapter: ImagesAdapter by lazy {
        ImagesAdapter()
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.getImages()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rv.apply {
            adapter = this@SecondFragment.adapter
            layoutManager = GridLayoutManager(context, 5)
        }

        val permission =ActivityCompat.checkSelfPermission(requireContext(),
        Manifest.permission.READ_EXTERNAL_STORAGE)

        if (permission == PackageManager.PERMISSION_GRANTED){
            viewModel.getImages()
        }else{
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        setImages()
    }

    private fun setImages(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.images.collect{
                    adapter.submitList(it)
                }
            }
        }
    }



}