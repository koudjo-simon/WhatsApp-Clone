package oks.ro.application2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import oks.ro.application2.model.Student

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref: SharedPreferences
    lateinit var studentRcv: RecyclerView
    lateinit var studentList: ArrayList<Student>

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

        studentRcv = findViewById(R.id.student_rcv)
        studentList = ArrayList()

        for(i in 1..50){
            studentList.add(Student("Student $i", "email$i@gmail.com","+2289712231$i"))
        }

        val adapter = StudentAdapter(studentList)
        studentRcv.layoutManager = LinearLayoutManager(this)
        studentRcv.adapter = adapter
    }
}