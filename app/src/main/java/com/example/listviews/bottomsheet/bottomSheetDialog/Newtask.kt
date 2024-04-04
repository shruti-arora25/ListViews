package com.example.listviews.bottomsheet.bottomSheetDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.listviews.bottomsheet.ViewModel.TaskVM
import com.example.listviews.databinding.FragmentNewtaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class newtask : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewtaskBinding
    private lateinit var taskVM: TaskVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewtaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskVM = ViewModelProvider(requireActivity()).get(taskVM::class.java)
        binding.saveBtn.setOnClickListener {
            saveAction()
        }
    }

    private fun saveAction() {
        taskVM.name.value = binding.name.text.toString()
        taskVM.desc.value = binding.desc.text.toString()
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }


}
