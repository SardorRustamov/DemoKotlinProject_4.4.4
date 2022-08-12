package com.example.demokotlinprojevct_1

import java.io.Serializable

class Member(private val object1: String,  val string1: String) : Serializable {
        override fun toString(): String {
            return "Name: $object1  Age: $string1"
        }
    }