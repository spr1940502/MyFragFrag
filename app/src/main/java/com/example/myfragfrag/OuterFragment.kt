package com.example.myfragfrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfragfrag.databinding.FragmentOuterBinding

class OuterFragment : Fragment() {
    private lateinit var _binding:FragmentOuterBinding
    private val binding get() = _binding!!
    private var text:String? = null
    class MyInnerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
        override fun getItemCount(): Int = 5
        override fun createFragment(position: Int): Fragment {
            return InnerFragment.newInstance(position.toString())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOuterBinding.inflate(inflater,container,false)
        binding.textOuterView.text = text
        binding.pager2.adapter = MyInnerAdapter()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            OuterFragment().apply {
                arguments = Bundle().apply {
                }
                this.text = name
            }
    }
}