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
    //大枠のフラグメントに画像IDリスト用変数を用意する。
    private var imgs:MutableList<Int>? = null

    class MyInnerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
        //内側のフラグメントで利用する画像IDのリスト用変数を用意する。
        private var imgs: MutableList<Int>? = null

        //画像IDのリストを設定するセッター
        fun setImgs(imgs:MutableList<Int>){
            this.imgs = imgs
        }
        //最初の画像IDは大枠で利用しているためサイズを一つ引く
        override fun getItemCount(): Int = imgs?.size!! - 1
        override fun createFragment(position: Int): Fragment {
            //最初の画像IDは大枠で利用するために１つ目の画像IDから内側のフラグメントで利用
            return InnerFragment.newInstance( imgs?.get(position + 1)!! )
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
        //内側のアダプターのインスタンスを生成
        val inad = MyInnerAdapter(this.requireActivity())
        //大枠のイメージビューにイメージを設定する。
        binding.outerImageView.setImageResource(imgs!![0])
        //内側のアダプターに画像IDリストを設定する。
        imgs?.let{ inad.setImgs(imgs!!)}
        //内側のフラグメントのpage2にアダプターを設定する。
        binding.pager2.adapter = inad
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(imgs:MutableList<Int>?) =
            OuterFragment().apply {
                arguments = Bundle().apply {
                }
                //大枠のフラグメントインスタンスに画像IDを設定する。
                this.imgs = imgs
            }
    }
}