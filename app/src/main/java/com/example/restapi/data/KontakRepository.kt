package com.example.restapi.data

import com.example.restapi.model.Kontak

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>

    suspend fun isertKOntak(kontak : Kontak)

    suspend fun updateKontak(id: Int, kontak: Kontak)
}
