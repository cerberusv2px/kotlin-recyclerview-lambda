package com.evolve.kotlinrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stdAdapter = StudentAdapter(getData())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = stdAdapter
        }

        stdAdapter.setStudentClickListener(object : StudentListener {
            override fun onStudentClick(std: Student, position: Int) {
                println(std)
            }
        })
    }

    private fun getData(): List<Student> {
        return listOf(
                Student("Sasdf"),
                Student("Sdf"),
                Student("Mlddf")
        )
    }
}
