package org.techtown.jsoupex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.jsoupex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private val binding get()=mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.newrecbtn.setOnClickListener{
            var newrecIntent=Intent(this,NewRecMainActivity::class.java)
            startActivity(newrecIntent)
        }
        binding.romancebtn.setOnClickListener {
            var romanceIntent= Intent(this,Romancewebtoon::class.java)
            startActivity(romanceIntent)
        }
        binding.actionbtn.setOnClickListener {
            var actionIntent=Intent(this,Actionwebtoon::class.java)
            startActivity(actionIntent)
        }
        binding.thrillerbtn.setOnClickListener {
            var thrillerIntent=Intent(this,Thrillerwebtoon::class.java)
            startActivity(thrillerIntent)

        }
        binding.periodbtn.setOnClickListener {
            var periodIntent=Intent(this,Periodwebtoon::class.java)
            startActivity(periodIntent)
        }
        binding.fantasybtn.setOnClickListener {
            var fantasyIntent=Intent(this,Periodwebtoon::class.java)
            startActivity(fantasyIntent)
        }

    }


}