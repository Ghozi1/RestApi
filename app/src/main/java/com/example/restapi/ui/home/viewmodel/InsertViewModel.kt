package com.example.restapi.ui.home.viewmodel

import com.example.restapi.model.Kontak
import com.example.restapi.repositori.KontakRepository

class InsertViewModel(private val kontakRepository: KontakRepository) : viewModel(){

}

data class InsertUiEvent(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val nohp: String = ""
)

fun InsertUiEvent.toKontak() : Kontak = Kontak(
    id = id,
    nama = nama,
    alamat = alamat,
    nohp = nohp
)

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)