package ru.skillbranch.phone_shop.view.ViewModel

class Event<T>(private val value: T){
    private var handled: Boolean = false
    fun getValue(): T? {
        if (handled) null
        else
       handled = true
        return value
    }
}

class Info(val title:String,val imgUrl:String,val  price:String)