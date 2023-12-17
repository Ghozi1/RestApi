package com.example.restapi

import android.app.Application
import com.example.restapi.repositori.AppContainer
import com.example.restapi.repositori.KontakContainer

class KontakAplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = KontakContainer()
    }
}