package com.example.desktop.ui.to_do_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desktop.FacultyAdapter
import com.example.desktop.FacultyData
import com.example.desktop.R
import com.example.desktop.databinding.FragmentToDoListBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentToDoListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentToDoListBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        val facultyList = listOf(
            FacultyData(1, "Mr. Shivam Gupta", "Bhai Parmanand DSEU Campus", "", ""),
            FacultyData(2, "Dr. Ghanshyam", "Ambedkar DSEU Campus", "", ""),
            FacultyData(3, "Mrs. Shelly Goel", "Ambedkar DSEU Campus", "", ""),
            FacultyData(4, "Mr. J P Soja", "Ambedkar DSEU Campus", "", ""),
            FacultyData(5, "Dr. Mamta Senger", "Ambedkar DSEU Campus", "", "")
        )

        // 2. Find RecyclerView
        val recyclerView: RecyclerView = binding.facultyRecyclerView

        // 3. Set Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        // 4. Set Adapter
        val adapter = FacultyAdapter(facultyList)
        recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}