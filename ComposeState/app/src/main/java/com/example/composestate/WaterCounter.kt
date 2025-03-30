package com.example.composestate


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessCounter(modifier: Modifier = Modifier) {
    Column(modifier =  Modifier.padding(16.dp, 48.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if(count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }
            if(showTask){
                WellnessTaskItem(onClose = {showTask = false}, taskName = "Have you taken your 15 minute walk today?", checked = false, onCheckedChange = {})
            }
            Text("You have $count glasses.")
        }
        Row(modifier = Modifier.padding(top = 16.dp)) {
            Button(onClick = { count++ },  enabled = count < 10) {
                Text("Add One")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(onClick = { count = 0 }, enabled = count > 0) {
                Text("Clear Water counts")
            }
        }
    }
}