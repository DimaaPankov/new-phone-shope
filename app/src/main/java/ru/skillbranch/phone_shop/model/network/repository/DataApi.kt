package ru.skillbranch.phone_shop.model.network.repository



interface DataApi {
     suspend fun <JsonData> getData():JsonData
}