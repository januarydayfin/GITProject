package com.krayapp.gitproject.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.krayapp.gitproject.data.retrofit2.IDataSource
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class GitRepo {
    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    val api = retrofit.create(IDataSource::class.java)

    val repositories = Observable.fromIterable(
        mutableListOf(
            GitUser("login1"),
            GitUser("login2"),
            GitUser("login3"),
            GitUser("login4"),
            GitUser("login5")
        )
    )
}

