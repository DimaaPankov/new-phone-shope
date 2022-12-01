package ru.skillbranch.data.network.service


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.skillbranch.phone_shop.entietis.JsonData


private const val BASE_URL = "https://run.mocky.io/"

val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


interface ApiService {
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhotos(): JsonData
}
object retrofitApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java)}
}