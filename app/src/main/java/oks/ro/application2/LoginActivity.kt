package oks.ro.application2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import oks.ro.application2.utils.UtilsFunctions

class LoginActivity : AppCompatActivity() {
    lateinit var emailEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var validerBtn: Button
    lateinit var goToRegisterPageTv: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEdt = findViewById(R.id.l_email_edt)
        passwordEdt = findViewById(R.id.l_password_edt)
        validerBtn = findViewById(R.id.l_valider_btn)
        goToRegisterPageTv = findViewById(R.id.l_go_to_register_page)

        validerBtn.setOnClickListener {
            if (validerFormulaire()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


        goToRegisterPageTv.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    private fun validerFormulaire(): Boolean{
        var isOk = true
        val emailEdtText = emailEdt.text.toString()
        val passwordEdtText = passwordEdt.text.toString()
        if (emailEdtText == null || emailEdtText.isEmpty()){
            emailEdt.error = "Veuillez renseignez cette information"
            isOk = false
        }else{
            if(!UtilsFunctions.isValidEmail(emailEdtText)){
                emailEdt.error = "Email invalid"
                isOk = false
            }else{
                emailEdt.error = null
            }
        }
        if (passwordEdtText == null || passwordEdtText.isEmpty() ){
            passwordEdt.error = "Veuillez renseignez cette information"
            isOk = false
        }else{
            passwordEdt.error == null
        }
        return isOk
    }
}