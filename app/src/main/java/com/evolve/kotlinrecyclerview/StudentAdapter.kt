package com.evolve.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StudentAdapter(
        var studentList: List<Student>,
        private val listener: (Student, Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.studentName.text = student.name
        holder.itemView.setOnClickListener {
            listener(student, position)
        }
    }


    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var studentName: TextView = itemView.findViewById(R.id.textView)


    }
}