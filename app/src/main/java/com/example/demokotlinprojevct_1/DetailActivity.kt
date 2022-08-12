package com.example.demokotlinprojevct_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    fun initViews() {
        val tv_detail = findViewById<TextView>(R.id.tv_detail)
        val b_exit = findViewById<Button>(R.id.b_exit)
        val member = Member("Object", "Thank you!")
        b_exit.setOnClickListener { backToFinish(member) }
        val user: User? = intent.getSerializableExtra("user") as User?
        tv_detail.setText(user.toString())
    }

    fun backToFinish(member: Member) {
        val intent = Intent()
        intent.putExtra("result", member)
        setResult(RESULT_OK, intent)
        finish()
    }
}