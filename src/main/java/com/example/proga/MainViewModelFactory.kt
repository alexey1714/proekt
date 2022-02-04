package com.example.proga

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proga.data.Repository
import com.example.proga.data.RoomStorage
import com.example.proga.data.SharedPrefDataStorage
import com.example.proga.domain.GetDataUseCase
import com.example.proga.domain.SaveDataUseCase


class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    private val dataRepository by lazy(LazyThreadSafetyMode.NONE) {
        Repository(dataStorage = SharedPrefDataStorage(context = context))
    }

    private val getDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetDataUseCase(dataRepository = dataRepository)
    }

    private val saveDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveDataUseCase(dataRepository = dataRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getDataUseCase = getDataUseCase, saveDataUseCase = saveDataUseCase) as T
    }
}