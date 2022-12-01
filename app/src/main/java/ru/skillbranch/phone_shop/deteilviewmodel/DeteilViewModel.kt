package ru.skillbranch.phone_shop.deteilviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.phone_shop.view.ViewModel.Event
import ru.skillbranch.phone_shop.view.ViewModel.Info

class DeteilViewModel() : ViewModel() {
    private val _args  = MutableLiveData<Event<Info>>()
    val args = _args

    private val _event  = MutableLiveData<Event<Boolean>>()
    val event = _event

    private val _eventShowMasseg  = MutableLiveData<Event<Boolean>>()
    val eventShowMasseg = _eventShowMasseg


    fun setDataArgs(title:String,imgIRL:String,price:String){
      _args.value =  Event(Info(title,imgIRL,price))
    }

    fun eventBack(){
        _event.value = Event(true)
    }

    fun eventShowMassege(){
        _eventShowMasseg.value = Event(true)
    }

}