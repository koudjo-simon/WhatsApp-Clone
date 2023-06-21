package oks.ro.application2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
//    Déclaration des Views
    lateinit var namesEdt: EditText
    lateinit var emailEdt: EditText
    lateinit var telEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var confirmPasswordEdt: EditText
    lateinit var validerBtn: Button
    lateinit var goToLoginPageTv: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Liason avec les Views
        namesEdt = findViewById(R.id.r_nom_prenom_edt)
        emailEdt = findViewById(R.id.r_email_edt)
        telEdt = findViewById(R.id.r_tel_edt)
        passwordEdt = findViewById(R.id.r_mdp_edt)
        confirmPasswordEdt = findViewById(R.id.r_conf_mdp_edt)
        validerBtn = findViewById(R.id.r_valider_btn)
        goToLoginPageTv = findViewById(R.id.go_to_login_page)

        // Gestion du click sur le button valider
        validerBtn.setOnClickListener {
            if (validerFormulaire()){
                val intent = Intent(this, MainActivity::class.java)
                val map: HashMap<String, String> = HashMap()
                map.put("names", namesEdt.text.toString())
                map.put("email", emailEdt.text.toString())
                map.put("tel", telEdt.text.toString())
                map.put("password", telEdt.text.toString())
                intent.putExtra("userInfo", map)
                startActivity(intent)
            }
        }

        // Gestion du click sur le `se connecter`
        goToLoginPageTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun validerFormulaire(): Boolean{
        var isOk = true
        val namesEdtText = namesEdt.text.toString()
        val emailEdtText = emailEdt.text.toString()
        val telEdtText = telEdt.text.toString()
        val passwordText = passwordEdt.text.toString()
        val confirmPasswordEdtText = confirmPasswordEdt.text.toString()
        if (namesEdtText == null || namesEdtText.length < 3){
            namesEdt.error = "Le nom doit contenir au moins 3 charactères"
            isOk = false
        }else {
            namesEdt.error = null
        }
        if (emailEdtText == null){
            emailEdt.error = "Veillez renseigner ce champ"
            isOk = false
        }else {
            emailEdt.error = null
        }
        if (telEdtText == null){
            telEdt.error = "Veillez renseigner ce champ"
            isOk = false
        }else {
            telEdt.error = null
        }
        if (passwordText == null){
            namesEdt.error = "Veillez renseigner ce champ"
            isOk = false
        }else {
            if (!passwordText.equals(confirmPasswordEdtText, ignoreCase = false)){
                passwordEdt.error = "Mot de passe non identiques"
                confirmPasswordEdt.error = passwordEdt.error.toString()
                isOk = false
            }else{
                passwordEdt.error = null
                confirmPasswordEdt.error = null
            }
        }
        return isOk
    }

}