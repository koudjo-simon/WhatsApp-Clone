package oks.ro.application2

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import oks.ro.application2.model.Student


class StudentAdapter(var studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.update(student)
        holder.row.setOnClickListener {
            val intent = Intent(holder.itemView.context, SettingsActivity::class.java)
            intent.putExtra("USERNAME", student.fullName)
            holder.itemView.context.startActivity(intent)
        }
        holder.phoneNumber.setOnClickListener{
            val callNumber = student.phone
            val number = Uri.parse("tel:$callNumber")
            val callIntent = Intent(Intent.ACTION_DIAL, number)
            holder.itemView.context.startActivity(callIntent)
        }
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profile: ImageView = itemView.findViewById(R.id.item_row_profile)
        var fullname: TextView = itemView.findViewById(R.id.item_row_username)
        var email: TextView = itemView.findViewById(R.id.item_row_email)
        var phoneNumber: ImageView = itemView.findViewById(R.id.item_row_tel)
        var row: LinearLayout = itemView.findViewById(R.id.row)
        fun update(student: Student) {
            fullname.text = student.fullName
            email.text = student.email
        }

    }
}