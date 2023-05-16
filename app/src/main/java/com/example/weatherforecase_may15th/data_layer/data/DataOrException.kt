package com.example.weatherforecase_may15th.data

class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: kotlin.Boolean? = null,
    var e: E? = null)