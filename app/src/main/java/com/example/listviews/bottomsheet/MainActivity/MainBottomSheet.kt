package com.example.listviews.bottomsheet.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.listviews.bottomsheet.bottomSheetDialog.newtask
import com.example.listviews.bottomsheet.ViewModel.TaskVM
import com.example.listviews.databinding.ActivityMainBottomSheetBinding


class MainBottomSheet : AppCompatActivity() {
    private lateinit var bind: ActivityMainBottomSheetBinding

    private lateinit var taskVM: TaskVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBottomSheetBinding.inflate(layoutInflater)
        setContentView(bind.root)
        taskVM = ViewModelProvider(this).get(TaskVM::class.java)

        bind.newtaskBtn.setOnClickListener {
            newtask().show(supportFragmentManager, "new Task")
        }

        taskVM.name.observe(this) {
            bind.nameTask.text = String.format("Name of Task is: %s", it)

        }
        taskVM.desc.observe(this) {
            bind.DescTask.text = String.format("Description of task is: %s", it)


        }

    }
}