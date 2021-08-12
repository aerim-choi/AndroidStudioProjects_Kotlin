package org.techtown.jsoupex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.jsoupex2.databinding.ActivityRecwebtoonBinding
import org.techtown.jsoupex2.databinding.ActivityRecwebtoonresBinding

class Recwebtoonres : AppCompatActivity() {
    private var mBinding: ActivityRecwebtoonresBinding?=null
    private val binding get()=mBinding!!

    val res1:Boolean?=Question1Fragment.question1
    val res2:Boolean?=Question2Fragment.question2
    val res3:Boolean?=Question3Fragment.question3
    val res4:Boolean?=Question4Fragment.question4
    val res5:Boolean?=Question5Fragment.question5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =  ActivityRecwebtoonresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //추천작1
        
        //추천작2

        //추천작3


    }
}