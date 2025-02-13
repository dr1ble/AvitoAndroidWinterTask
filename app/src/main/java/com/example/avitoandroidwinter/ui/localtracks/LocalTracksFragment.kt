package com.example.avitoandroidwinter.ui.localtracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.avitoandroidwinter.databinding.FragmentLocalTracksBinding

import com.example.avitoandroidwinter.ui.utils.daggerViewModel

class LocalTracksFragment : Fragment() {

    private var _binding: FragmentLocalTracksBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: LocalTracksViewModel by daggerViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentLocalTracksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}