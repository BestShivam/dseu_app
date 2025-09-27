package com.example.desktop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FacultyAdapter(private val facultyList: List<FacultyData>) :
    RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    // Inner class for ViewHolder
    class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sNo: TextView = itemView.findViewById(R.id.text_s_no)
        val facultyName: TextView = itemView.findViewById(R.id.text_faculty_name)
        val timeTable: TextView = itemView.findViewById(R.id.text_view_time_table)
        val campusName: TextView = itemView.findViewById(R.id.text_campus_name)
        val location: EditText = itemView.findViewById(R.id.edit_location)
        val uploadPhoto: TextView = itemView.findViewById(R.id.text_upload_photo)
        val remark: EditText = itemView.findViewById(R.id.edit_remark)
    }

    // 1. Inflate the row layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_faculty, parent, false)
        return FacultyViewHolder(view)
    }

    // 2. Bind data to the views
    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val currentItem = facultyList[position]

        holder.sNo.text = "${currentItem.sNo}."
        holder.facultyName.text = currentItem.facultyName
        holder.campusName.text = currentItem.campusName

        // Handle interactive/actionable views (Time Table, Photo)
        holder.timeTable.setOnClickListener { /* Handle 'View Time Table' click */ }
        holder.uploadPhoto.setOnClickListener { /* Handle 'Upload Photo' click (e.g., open camera/gallery) */ }

        // Handle data persistence for EditTexts (Important for RecyclerView reuse)
        holder.location.setText(currentItem.location)
        holder.remark.setText(currentItem.remark)

        // Add a TextWatcher to save user input back to the data model
        // This is complex for a simple example but crucial for persistent user input
    }

    // 3. Return the total number of items
    override fun getItemCount() = facultyList.size
}