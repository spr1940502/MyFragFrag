package com.example.myfragfrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfragfrag.databinding.FragmentInnerBinding

class InnerFragment : Fragment() {
    private lateinit var _binding: FragmentInnerBinding
    private val binding get() = _binding!!

    private var text : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInnerBinding.inflate(inflater,container,false)
        binding.textInnerView.text = text
        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance(text: String) =
            InnerFragment().apply {
                arguments = Bundle().apply {
                }
                this.text = text
            }
    }
}