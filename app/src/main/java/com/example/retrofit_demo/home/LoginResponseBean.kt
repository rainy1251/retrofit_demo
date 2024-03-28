package com.example.retrofit_demo.home

data class LoginResponseBean(
    val classId: String,
    val gradeId: String,
    val headPhoto: String,
    val phone: String,
    val schoolId: String,
    val schoolName: String,
    val schoolVersion: Int,
    val teacherId: String,
    val teacherName: String,
    val token: String
)