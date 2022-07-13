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
        private var sno:String? = null
        fun setScene(sno:String){
            this.sno = sno
        }
        override fun getItemCount(): Int = 5
        override fun createFragment(position: Int): Fragment {
            return InnerFragment.newInstance(  this.sno + " - " + position.toString() )
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
        var inad = MyInnerAdapter(this.requireActivity())
        text?.let { inad.setScene(it) }
        binding.pager2.adapter = inad
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