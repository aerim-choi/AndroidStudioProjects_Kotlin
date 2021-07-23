package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.drawer.Fragment1
import org.techtown.drawer.Fragment2
import org.techtown.drawer.Fragment3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //외부버튼
        Image1.setOnClickListener {
            val outsideIntent= Intent(this,outsidePage::class.java)
            startActivity(outsideIntent)
        }
        //외부버튼
        Image2.setOnClickListener{
            val insideIntent= Intent(this,insidePage::class.java)
            startActivity(insideIntent)
        }

    }
}