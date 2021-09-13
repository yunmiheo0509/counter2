package com.example.counter2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val handle:SavedStateHandle) : ViewModel() { //여기 handle을 추가하면 아까 main에서 짠  onSaveInstanceState()이런거 할 필요 없다
    private var count = handle.get<Int>("count") ?:0
        set(value) { //count값이 바뀔떄 그값이 value로 들어올것이다 코틀린의 settter를 오버라이드
            field = value
            countLiveData.value = count //강제종료돼도 값이 유지되도록
            handle.set("count", value)


        }
    val countLiveData = MutableLiveData<Int>()

    fun increaseCount() {
        count++
    }

    fun decreaseCount() {
        count--
    }
}