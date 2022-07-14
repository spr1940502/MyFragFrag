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
    //内側のインスタンスで表示する画像IDを設定する。
    private var imgid : Int? = null

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
        //内側のインスタンスのイメージビューに画像を設定する。
        binding.innerImageView.setImageResource(this.imgid!!)
        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance(imgid: Int?) =
            InnerFragment().apply {
                arguments = Bundle().apply {
                }
                //内側のインスタンスで利用する画像IDを保存する。
                this.imgid = imgid
            }
    }
}