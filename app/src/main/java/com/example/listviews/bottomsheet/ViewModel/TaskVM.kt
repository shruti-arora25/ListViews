package com.example.listviews.bottomsheet.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskVM : ViewModel() {

    var name = MutableLiveData<String>()
    var desc = MutableLiveData<String>()

}