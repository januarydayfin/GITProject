package com.krayapp.gitproject.data.imageloader

interface IImageLoader<T> {
    fun loadInto(url:String, container: T)
}