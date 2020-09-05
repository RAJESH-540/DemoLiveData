package com.example.demolivedata.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val liveData=MutableLiveData<String>("Default value")

    fun setText(){
        liveData.postValue("New value")
    }
}