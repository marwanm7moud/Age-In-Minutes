package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import java.util.Calendar

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn =findViewById<Button>(R.id.btn_DatePicker)
        val selected = findViewById<TextView>(R.id.selected_date)
        val minuts = findViewById<TextView>(R.id.ageINMinutes)


        btn.setOnClickListener{
            val c = Calendar.getInstance();
           val df = DatePickerDialog(this , DatePickerDialog.OnDateSetListener{view , year , month , day ->
               selected.setText("${day}/${month+1}/${year}")




               val minutesinDays = 1440*(Period.between(LocalDate.of(year , month , day) , LocalDate.now() ).days)
              val minutesinMonth = (Period.between(LocalDate.of(year , month+1 , day) , LocalDate.now() ).months)*30*24*60
               val minutesinYear = (Period.between(LocalDate.of(year , month , day) , LocalDate.now() ).years)*12*30*24*60
               minuts.setText("${minutesinYear+minutesinMonth+minutesinDays}")


            }  ,c.get(Calendar.YEAR) , c.get(Calendar.MONTH) , c.get(Calendar.DAY_OF_MONTH)).show()
        }

    }
}