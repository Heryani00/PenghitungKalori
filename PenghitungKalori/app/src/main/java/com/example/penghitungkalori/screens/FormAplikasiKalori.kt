package com.example.penghitungkalori.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.penghitungkalori.model.AplikasiKalori
import com.example.penghitungkalori.persistences.AplikasiKaloriDao
import com.example.penghitungkalori.ui.theme.Purple700
import com.example.penghitungkalori.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormAplikasiKalori(AplikasiKaloriDao: AplikasiKaloriDao ) {
    val id = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val beratbadan = remember { mutableStateOf(TextFieldValue("")) }
    val tinggibadan = remember { mutableStateOf(TextFieldValue("")) }
    val umur = remember { mutableStateOf(TextFieldValue("")) }

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "id") },
            value = id.value,
            onValueChange = {
                id.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Kosongkan") }
        )

        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Nama") }

        )
        OutlinedTextField(
            label = { Text(text = "Berat Badan") },
            value = beratbadan.value,
            onValueChange = {
                beratbadan.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Berat Badan") }
        )
        OutlinedTextField(
            label = { Text(text = "Tinggi Badan") },
            value = tinggibadan.value,
            onValueChange = {
                tinggibadan.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Tinggi Badan") }
        )
        OutlinedTextField(
            label = { Text(text = "Umur") },
            value = umur.value,
            onValueChange = {
                umur.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Umur") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = AplikasiKalori(id, nama.value.text,
                    beratbadan.value.text, tinggibadan.value.text, umur.value.text)
                scope.launch {
                    AplikasiKaloriDao.insertAll(item)
                }
                nama.value = TextFieldValue("")
                beratbadan.value = TextFieldValue("")
                tinggibadan.value = TextFieldValue("")
                umur.value = TextFieldValue("")

            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                beratbadan.value = TextFieldValue("")
                tinggibadan.value = TextFieldValue("")
                umur.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}