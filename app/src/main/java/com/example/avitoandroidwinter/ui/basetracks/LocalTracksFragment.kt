package com.example.avitoandroidwinter.ui.basetracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.avitoandroidwinter.databinding.FragmentLocalTracksBinding
import kotlin.time.Duration.Companion.seconds

class LocalTracksFragment : Fragment() {

    private var _binding: FragmentLocalTracksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val localTracksViewModel =
            ViewModelProvider(this).get(LocalTracksViewModel::class.java)

        _binding = FragmentLocalTracksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        localTracksViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}