package com.example.myfragfrag

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfragfrag.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    class MyOuterAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
        override fun getItemCount(): Int = 3
        override fun createFragment(position: Int): Fragment {
            return OuterFragment.newInstance(position.toString())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pager.adapter = MyOuterAdapter(this)

    }
}