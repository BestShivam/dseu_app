package com.example.desktop

data class FacultyData(
    val sNo: Int,
    val facultyName: String,
    val campusName: String,
    val location: String, // Can be used to store the entered location
    val remark: String // Can be used to store the entered remark
)

val facultyList = listOf(
    FacultyData(1, "Mr. Shivam Gupta", "Bhai Parmanand DSEU Campus", "", ""),
    FacultyData(2, "Dr. Ghanshyam", "Ambedkar DSEU Campus", "", ""),
    FacultyData(3, "Mrs. Shelly Goel", "Ambedkar DSEU Campus", "", ""),
    FacultyData(4, "Mr. J P Soja", "Ambedkar DSEU Campus", "", ""),
    FacultyData(5, "Dr. Mamta Senger", "Ambedkar DSEU Campus", "", "")

)
