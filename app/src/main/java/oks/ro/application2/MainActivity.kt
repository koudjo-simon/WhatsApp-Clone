package oks.ro.application2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var settingsBtn: Button
    lateinit var usernameEdt: EditText
    lateinit var sharedPref: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences("LOGINSHAREPREF", MODE_PRIVATE)

        if (!sharedPref.contains("ISFIRSTLOGIN")){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        settingsBtn = findViewById(R.id.go_to_settings)
        usernameEdt = findViewById(R.id.username_edt)

        settingsBtn.setOnClickListener {
            println("***************** Settings Button clicked")

            val username = usernameEdt.text.toString()
            if (username.isEmpty() || username.length < 2){
                usernameEdt.error = "Nom d'utilisateur non valide"
            }else{
                usernameEdt.error = null
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }

    }
}