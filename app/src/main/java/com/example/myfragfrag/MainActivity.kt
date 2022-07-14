package com.example.myfragfrag

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfragfrag.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //１つ目のフラグメントで利用する画像ファイルをリソースで指定する。
    val imagefilename1:MutableList<String> = mutableListOf("a","i","j","k")
    //２つ目のフラグメントで利用する画像ファイルをリソースで指定する。
    val imagefilename2:MutableList<String> = mutableListOf("b","l","m","n")
    //リストを二次元化する。
    val images:MutableList<MutableList<String>> = mutableListOf(imagefilename1,imagefilename2)
    //リソースIDを格納するためのリストを作成する
    var imgids:MutableList<MutableList<Int>> = mutableListOf()

    private lateinit var binding : ActivityMainBinding

    class MyOuterAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
        //大枠のフラグメントで管理する画像IDのリストを保存する変数宣言
        private var imglist:MutableList<MutableList<Int>>? = null
        //画像IDのリストを格納する変数へのセッター
        fun setImageRes(imglist : MutableList<MutableList<Int>>){
            this.imglist = imglist
        }

        override fun getItemCount(): Int = imglist?.size!!

        override fun createFragment(position: Int): Fragment {
            //大枠フラグメントのインスタンスを生成する際に画像IDを渡す。
            return OuterFragment.newInstance(imglist?.get(position))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //大枠のアダプターのインスタンス生成
        val outerad:MyOuterAdapter = MyOuterAdapter(this)
        //大枠の画像IDの設定
        outerad.setImageRes(imgids)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //ページャーにアダプターを設定
        binding.pager.adapter = outerad
        for( img1 in images){
            imgids.add(mutableListOf())
            for(img2 in img1){
                //画像IDの読み込み
                 imgids[imgids.size-1].add(resources.getIdentifier(img2, "drawable", packageName))
            }
        }
    }
}