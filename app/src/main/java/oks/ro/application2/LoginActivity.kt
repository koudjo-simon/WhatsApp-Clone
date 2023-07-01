package oks.ro.application2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import oks.ro.application2.utils.UtilsFunctions

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var validerBtn: Button
    private lateinit var goToRegisterPageTv: TextView
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPref = getSharedPreferences("LOGINSHAREPREF", MODE_PRIVATE)

        goToRegisterPageTv = findViewById(R.id.l_go_to_register_page)
        emailEdt = findViewById(R.id.l_email_edt)
        passwordEdt = findViewById(R.id.l_password_edt)
        validerBtn = findViewById(R.id.l_valider_btn)
        goToRegisterPageTv = findViewById(R.id.l_go_to_register_page)

        validerBtn.setOnClickListener {
            if (validerFormulaire()) {
                editor = sharedPref.edit()
                editor.putBoolean("ISFIRSTLOGIN", false)
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


        goToRegisterPageTv.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    private fun validerFormulaire(): Boolean {
        var isOk = true
        val emailEdtText = emailEdt.text.toString()
        val passwordEdtText = passwordEdt.text.toString()
        if (emailEdtText.trim().isEmpty()) {
            emailEdt.error = "Veuillez renseignez cette information"
            isOk = false
        } else {
            if (!UtilsFunctions.isValidEmail(emailEdtText)) {
                emailEdt.error = "Email invalid"
                isOk = false
            } else {
                emailEdt.error = null
            }
        }
        if (passwordEdtText.trim().isEmpty()) {
            passwordEdt.error = "Veuillez renseignez cette information"
            isOk = false
        } else {
            passwordEdt.error = null
        }
        return isOk
    }
}