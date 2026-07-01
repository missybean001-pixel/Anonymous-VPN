package com.missybean.vpn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.missybean.vpn.weather.WeatherDashboardFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Load Weather Dashboard Fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WeatherDashboardFragment())
                .commit()
        }
    }
}
