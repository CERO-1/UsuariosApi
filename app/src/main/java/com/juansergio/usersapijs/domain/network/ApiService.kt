package com.juansergio.room.Domain.network


import com.juansergio.usersapijs.data.UsuariosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

     @GET("/users")
    suspend fun getInfo(@Query("id") id :String) :UsuariosResponse

    @GET("/users")
    suspend fun getAllUsers() :UsuariosResponse



}
