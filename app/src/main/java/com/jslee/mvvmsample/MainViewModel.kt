package com.jslee.mvvmsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.jslee.mvvmsample.data.AdRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {
    private val repository = AdRepository()

    private var _isUpdate = MutableLiveData<Boolean>()
    private val _adImages : LiveData<List<String>> = _isUpdate.switchMap {
        viewModelScope.launch {
            repository.refreshAdData()
        }
        repository.getAdImages()
    }

    val adImages : LiveData<List<String>>
        get() = _adImages

//    init {
//        refreshData()
//    }
//
//    private fun refreshData(){
//        viewModelScope.launch {
//            try {
//                repository.refreshAdData()
//            }catch (e:Exception){
//
//            }
//        }
//    }


}