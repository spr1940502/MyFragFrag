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
    class MyInnerAdapter1(fa: FragmentActivity): FragmentStateAdapter(fa){
        override fun getItemCount(): Int = 5
        override fun createFragment(position: Int): Fragment {
            return InnerFragment.newInstance(  "1 - " + position.toString() )
        }
    }
    class MyInnerAdapter2(fa: FragmentActivity): FragmentStateAdapter(fa){
        override fun getItemCount(): Int = 5
        override fun createFragment(position: Int): Fragment {
            return InnerFragment.newInstance(  "2 - " + position.toString() )
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
        if(text == "0")
            binding.pager2.adapter = MyInnerAdapter1(this.requireActivity())
        else
            binding.pager2.adapter = MyInnerAdapter2(this.requireActivity())
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