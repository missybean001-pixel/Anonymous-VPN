package com.anonymousvpn

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import android.view.Gravity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(Color.BLACK)
        layout.gravity = Gravity.CENTER

        val connect = Button(this)
        connect.text = "CONNECT"
        connect.setBackgroundColor(Color.parseColor("#00FF66"))
        connect.setTextColor(Color.BLACK)

        layout.addView(connect)
        setContentView(layout)
    }
}
