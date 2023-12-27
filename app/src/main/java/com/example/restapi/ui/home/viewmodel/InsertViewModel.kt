package com.example.restapi.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.restapi.model.Kontak
import com.example.restapi.repositori.KontakRepository
import java.io.IOException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InsertViewModel(private val kontakRepository: KontakRepository) : ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
        private set
    fun updateInsertKontakState(insertUiEvent: InsertUiEvent){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }
    suspend fun insertKontak(){
        viewModelScope.launch{
            try {
                kontakRepository.insertKontak(insertKontakState.insertUiEvent.toKontak())
            }catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
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

fun Kontak.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    id = id,
    nama = nama,
    alamat = alamat,
    nohp = nohp
)

fun Kontak.toUiStateKontak():InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)