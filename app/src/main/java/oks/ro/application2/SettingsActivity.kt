package oks.ro.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SettingsActivity : AppCompatActivity() {

    lateinit var usernameTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        usernameTv = findViewById(R.id.username_tv)
        usernameTv.text = intent?.getStringExtra("USERNAME")

    }
}