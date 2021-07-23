package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //외부버튼
        Image1.setOnClickListener {
            val outsideIntent= Intent(this,OutsidePage::class.java)
            startActivity(outsideIntent)
        }
        //외부버튼
        Image2.setOnClickListener{
            val insideIntent= Intent(this,InsidePage::class.java)
            startActivity(insideIntent)
        }

    }
}