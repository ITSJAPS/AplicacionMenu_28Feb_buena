package com.example.aplicacionmenu_28feb_buena.ui.Insertar

import android.app.AlertDialog
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

import com.example.aplicacionmenu_28feb_buena.databinding.FragmentInsertarBinding

class InsertarFragment : Fragment() {

    private var _binding: FragmentInsertarBinding? = null

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

        _binding = FragmentInsertarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView =root.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter()
        cargarEtiquetas(recyclerView,adapter)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object :CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int){
                var nombre = adapter.titles[position]
              //  AlertDialog.Builder(requireContext()).setTitle(" ${nombre}").show()
            }
        })
        return root
    }

    private fun cargarEtiquetas(recyclerView: RecyclerView, adapter: CustomAdapter) {
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}