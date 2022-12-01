package ru.skillbranch.data.network.repository

import kotlinx.coroutines.*
import ru.skillbranch.data.network.service.retrofitApi.retrofitService
import ru.skillbranch.phone_shop.entietis.JsonData
import ru.skillbranch.phone_shop.model.network.repository.DataApi


object DataImpl: DataApi {
    private var data: JsonData? = null


    override suspend fun <JsonData> getData():JsonData {
        coroutineScope{
            launch {
                try {
                    data = retrofitService.getPhotos()
                } catch (e: Exception) { }
            }
        }
        return data!! as JsonData
    }


}