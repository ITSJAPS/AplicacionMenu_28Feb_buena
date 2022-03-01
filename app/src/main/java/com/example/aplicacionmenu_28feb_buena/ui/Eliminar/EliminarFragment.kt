package com.example.aplicacionmenu_28feb_buena.ui.Eliminar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionmenu_28feb_buena.CustomAdapter
import com.example.aplicacionmenu_28feb_buena.R
import com.example.aplicacionmenu_28feb_buena.databinding.FragmentEliminarBinding

class EliminarFragment : Fragment() {

    private var _binding: FragmentEliminarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentEliminarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView =root.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}