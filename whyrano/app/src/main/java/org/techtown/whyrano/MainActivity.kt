package org.techtown.whyrano

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref=getSharedPreferences("checkFirst", Activity.MODE_PRIVATE)
        val checkFirst:Boolean=pref.getBoolean("checkFirst",false)

        if(checkFirst==false){
            print("앱최초실행")
            //앱 최초 실행시 하고 싶은 작업
            val editor:SharedPreferences.Editor=pref.edit()
            editor.putBoolean("checkFirst",true)
            editor.commit()

            val guideIntent=Intent(this,MyPager::class.java)
            startActivity(guideIntent)

            finish()
        }else{
             maintext.text="안녕하세요"
        }


    }
}