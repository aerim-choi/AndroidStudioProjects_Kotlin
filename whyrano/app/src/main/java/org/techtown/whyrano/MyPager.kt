package org.techtown.whyrano

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_mypager.*

class MyPager: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypager)
        val SPLASH_TIME_OUT:Long = 9000 // 3 sec
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, MainActivity::class.java))

            // close this activity
            finish()
        },SPLASH_TIME_OUT)

        pager.adapter =PagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit = 3

        indicator.setViewPager(pager)
        //indicator 3개만들고 첫번째꺼를 보여준다.
        indicator.createIndicators(3,0)

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                showToast("페이지 선택: ${position}")
                indicator.animatePageSelected(position)
            }
        })
        button.setOnClickListener {
            pager.currentItem = 0
        }
        button2.setOnClickListener {
            pager.currentItem = 1
        }
        button3.setOnClickListener {
            pager.currentItem = 2
        }

    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
    }
    inner class PagerAdapter : FragmentStateAdapter{
        //생성자
        constructor(activity: FragmentActivity):super(activity)
        //아이템이 몇개있냐
        override fun getItemCount()=3

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->{
                    Fragment1()
                }
                1->{
                    Fragment2()
                }
                2->{
                    Fragment3()
                }
                else->{
                    Fragment1()
                }
            }
        }
    }
}

