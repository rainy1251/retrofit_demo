package com.iphoto.plus.home

class WeekPlanListBean : ArrayList<WeekPlanListBeanItem>()

data class WeekPlanListBeanItem(
    val endDate: String,
    val gradeId: String,
    val id: String,
    val planName: String,
    val selected: Boolean,
    val startDate: String
)