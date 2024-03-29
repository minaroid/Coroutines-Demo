package com.mina.coroutinesdemo.ui.home

import androidx.lifecycle.MutableLiveData
import com.mina.coroutinesdemo.base.BaseViewModel
import com.mina.coroutinesdemo.store.repo.HomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//https://medium.com/androiddevelopers/easy-coroutines-in-android-viewmodelscope-25bffb605471
//https://developer.android.com/topic/libraries/architecture/coroutines
class HomeViewModel : BaseViewModel() {

    private val repo: HomeRepo = HomeRepo()

    val liveData = MutableLiveData<String>()
//    private val users: MutableLiveData<String> by lazy {
//        MutableLiveData().also {
////            loadUsers()
//        }
//    }
    init {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                liveData.postValue(repo.getData().toString())
            }
        }
    }
}