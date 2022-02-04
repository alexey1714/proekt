package com.example.proga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.proga.databinding.FragmentSettingRedaktorBinding
import com.example.proga.domain.DataRepository


class SettingRedaktorFragment : Fragment() {

    lateinit var binding: FragmentSettingRedaktorBinding
    private lateinit var vm: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSettingRedaktorBinding.inflate(inflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(requireActivity(), MainViewModelFactory(requireContext()))[MainViewModel::class.java]
        vm.resultLiveData.observe(this, { text ->
            binding.name.setText(text.toString())
        })
        binding.saveSet.setOnClickListener {
            if (binding.name.text.isNotEmpty()){
                vm.save(binding.name.text.toString())
            }
        }


    }
}