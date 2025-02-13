package com.example.avitoandroidwinter.ui.apitracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.avitoandroidwinter.MainActivity
import com.example.avitoandroidwinter.databinding.FragmentApiTracksBinding
import com.example.avitoandroidwinter.ui.localtracks.LocalTracksViewModel
import com.example.avitoandroidwinter.ui.utils.daggerViewModel

class ApiTracksFragment : Fragment() {

    private var _binding: FragmentApiTracksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: ApiTracksViewModel by daggerViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel
        _binding = FragmentApiTracksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}