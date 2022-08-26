package com.example.firstscreen.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.core.navigate
import com.example.core.modelhelper.Education
import com.example.core.navigatehelper.NavCommand
import com.example.core.navigatehelper.NavCommands
import com.example.firstscreen.R
import com.example.firstscreen.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val viewModel by viewModels<FirstViewModel>()

    private val binding by viewBinding(FragmentFirstBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        nextFragment()
    }

    private fun getData() = with(binding){
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.user.collect{
                image.load(it?.user?.photo)
                name.text = it?.user?.first_name
                secondName.text = it?.user?.second_name
                setEducation(it?.user?.education)
                companyName.text = it?.user?.company?.get(0)?.name
                position.text = it?.user?.company?.get(0)?.position
            }
        }
    }
    }

    private fun setEducation(status: Int?) = with(binding){
        when(status){
            Education.HighSchool.int -> education.text = Education.HighSchool.educ
            Education.Bachelor.int -> education.text = Education.Bachelor.educ
            Education.Master.int -> education.text = Education.Master.educ
            Education.Doctoral.int -> education.text = Education.Doctoral.educ

        }

    }

    private fun nextFragment(){
        binding.btnNext.setOnClickListener {
            navigate(
                NavCommand(
                    NavCommands.DeepLink(
                        url = Uri.parse("http://www.attractor.com/second/"),
                        isModal = true,
                        isSingleTop = false
                    )
                )
            )
        }
    }
}