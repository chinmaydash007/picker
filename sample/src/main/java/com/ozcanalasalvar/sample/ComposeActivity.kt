package com.ozcanalasalvar.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.timepicker.TimeFormat
import com.ozcanalasalvar.datepicker.compose.datepicker.WheelDatePicker
import com.ozcanalasalvar.datepicker.compose.timepicker.WheelTimePicker
import com.ozcanalasalvar.datepicker.model.Time
import com.ozcanalasalvar.datepicker.utils.DateUtils

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // A surface container using the 'background' color from the theme
        WheelDatePicker(onDateChanged = { day, month, year, date ->
            Log.d("SelectedDate", "$day / $month / $year")
        })

        Spacer(modifier = Modifier.height(20.dp))

        WheelDatePicker(offset = 3, textSize = 16, onDateChanged = { day, month, year, date ->
            Log.d("SelectedDate", "$day / $month / $year")
        })

        Spacer(modifier = Modifier.height(20.dp))
        WheelTimePicker(offset = 3, onTimeChanged = { hour, minute, format ->
            Log.d("SelectedDate", "$hour : $minute  $format")
        })
        Spacer(modifier = Modifier.height(20.dp))

        WheelTimePicker(
            startTime = Time(12, 34,"PM"),
            timeFormat = TimeFormat.CLOCK_12H,
            onTimeChanged = { hour, minute, format ->
                Log.d("SelectedDate", "$hour : $minute  $format")
            })
    }
}

@Preview
@Composable
fun ContentPreview() {
    Content()
}