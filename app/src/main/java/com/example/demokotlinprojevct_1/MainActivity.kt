package com.example.demokotlinprojevct_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var LAUNCH_DETAIL = 1001
    var tv_home: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val member = data!!.getSerializableExtra("result") as Member?
            tv_home!!.text = member.toString()
        }
    }

    fun initViews() {
        tv_home = findViewById(R.id.tv_home)
        val b_open_details = findViewById<Button>(R.id.b_detail)
        b_open_details.setOnClickListener {
            val user = User("Sardor", 22)
            openDetailActivity(user)
        }
    }

    fun openDetailActivity(user: User?) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("user", user)
        detailLauncher.launch(intent)
    }
}