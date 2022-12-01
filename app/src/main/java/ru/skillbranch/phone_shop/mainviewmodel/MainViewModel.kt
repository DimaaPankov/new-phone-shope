package ru.skillbranch.phone_shop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.skillbranch.phone_shop.entietis.BestSeller
import ru.skillbranch.phone_shop.entietis.HomeStore
import ru.skillbranch.phone_shop.entietis.JsonData
import ru.skillbranch.phone_shop.model.network.repository.DataApi
import ru.skillbranch.phone_shop.view.ViewModel.Event
import ru.skillbranch.phone_shop.view.ViewModel.Info


enum class Status { LOADING, ERROR, DONE }

class MainViewModel(val dataBase: DataApi) : ViewModel(){
    private val _data = MutableLiveData<JsonData>()
    val data: LiveData<JsonData> = _data

    private val _eventNavigationToDeteil = MutableLiveData<Event<Info>>()
    val eventNavigation = _eventNavigationToDeteil

    private val _status = MutableLiveData<Status>()
    val status = _status

    private val _indexHotSilers = MutableLiveData<Int>()

    init {
        getData()
    }

   private  fun getData(){
       viewModelScope.launch {
       _status.value = Status.LOADING
       try {
       _data.value = dataBase.getData()
           _status.value = Status.DONE
       }catch (e: Exception) {
           _status.value = Status.ERROR
       }
       }
}

   //  fun getDataHome_store(): List<HomeStore>? {
  //      return _data.value?.home_store
  //  }

     fun getDataBestSeller(): List<BestSeller>? {
        return _data.value?.bestSeller
    }

    fun eventNavigationToDeteil(imageUrl:String,title:String,price:String){
        _eventNavigationToDeteil.value = Event(Info(imageUrl,title,price))
    }
    var i  = 0
    fun countindexHotSilers(){
        if(_indexHotSilers.value?:0 < 3) {
             ++i
        }else{
            i = 0
        }
        _indexHotSilers.value = i
    }
}