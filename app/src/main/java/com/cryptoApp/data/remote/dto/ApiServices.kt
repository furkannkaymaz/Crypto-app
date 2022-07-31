package com.cryptoApp.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("genre/movie/list")
    suspend fun getMovieGenres(
        @Query("api_key") api: String,
        @Query("language") language: String
    ): String

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") api: String,
        @Query("sort_by") sort: String,
        @Query("include_adult") include_adult: Boolean,
        @Query("include_video") include_video: Boolean,
        @Query("page") page: Int,
        @Query("with_genres") withGenres: Int,
    ): String
}