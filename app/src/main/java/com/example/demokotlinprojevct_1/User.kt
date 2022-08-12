package com.example.demokotlinprojevct_1

import java.io.Serializable

class User(private val name: String,  val age: Int) : Serializable {
    override fun toString(): String {
        return "Name: $name  Age: $age"
    }
}