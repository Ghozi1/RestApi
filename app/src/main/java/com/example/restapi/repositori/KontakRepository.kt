package com.example.restapi.repositori

import com.example.restapi.model.Kontak
import com.example.restapi.network.KontakService

interface KontakRepository {
    /** Fetches List of Kontak from KontakApi */
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches List of Kontak from KontakApi*/
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}