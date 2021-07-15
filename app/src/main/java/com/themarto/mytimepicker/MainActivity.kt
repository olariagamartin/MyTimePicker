package com.themarto.mytimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var timeText: TextView
    private lateinit var showDialogBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeText = findViewById(R.id.timeText)
        showDialogBtn = findViewById(R.id.showDialogButton)

        showDialogBtn.setOnClickListener {

            val timePicker = MyTimePicker()
            timePicker.setTitle("Select time")
            //timePicker.includeHours = false
            timePicker.setOnTimeSetOption("Set time") {hour, minute, second ->
                timeText.text = "$hour : $minute : $second"
            }

            /* To show the dialog you have to supply the "fragment manager"
                and a tag (whatever you want)
             */
            timePicker.show(supportFragmentManager, "time_picker")
        }
    }
}