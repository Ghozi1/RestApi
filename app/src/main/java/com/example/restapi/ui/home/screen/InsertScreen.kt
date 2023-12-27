package com.example.restapi.ui.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.restapi.ui.home.viewmodel.InsertUiEvent
import com.example.restapi.ui.home.viewmodel.InsertUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputSiswa(
    insertUiEvent: InsertUiEvent,
    modifier: Modifier = Modifier,
    onValueChange : (InsertUiEvent) -> Unit = {},
    enable : Boolean = true
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertUiEvent.nama,
            onValueChange ={onValueChange(insertUiEvent.copy(nama = it))},
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enable,
            singleLine = true,
        )
        OutlinedTextField(
            value = insertUiEvent.alamat,
            onValueChange ={onValueChange(insertUiEvent.copy(alamat = it))},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enable,
            singleLine = true,
        )
        OutlinedTextField(
            value = insertUiEvent.nohp,
            onValueChange ={onValueChange(insertUiEvent.copy(nohp = it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Telepon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enable,
            singleLine = true
        )
        Divider(
            thickness = 8.dp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
    }
}

@Composable
fun EntryKontakBody(
    insertUiState: InsertUiState,
    onSiswaValueChange : (InsertUiEvent) -> Unit,
    onSaveClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Column (
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier.padding(12.dp)
    ){
        FormInputSiswa(
            insertUiEvent = insertUiState.insertUiEvent,
            onValueChange = onSiswaValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Simpan")
        }
    }
}