package org.techtown.intropage

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Checking for first time launch - before calling setContentView()
        prefManager = PrefManager(this)
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen()
            finish()
        }

        setContentView(R.layout.activity_welcome)



        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = intArrayOf(
            R.layout.welcome_slide1,
            R.layout.welcome_slide2,
            R.layout.welcome_slide3,
            R.layout.welcome_slide4
        )

        // adding bottom dots
        addBottomDots(0)

        // making notification bar transparent
        changeStatusBarColor()
        myViewPagerAdapter = MyViewPagerAdapter()
        viewPager!!.adapter = myViewPagerAdapter
        viewPager!!.addOnPageChangeListener(viewPagerPageChangeListener)
        btnSkip.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                launchHomeScreen()
            }
        })
        btnNext.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                // checking for last page
                // if last page home screen will be launched
                val current = getItem(+1)
                if (current < layouts.size) {
                    // move to next screen
                    viewPager!!.currentItem = current
                } else {
                    launchHomeScreen()
                }
            }
        })
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)
        dotsLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(colorsInactive[currentPage])
            dotsLayout!!.addView(dots[i])
        }
        if (dots.size > 0) dots[currentPage]!!.setTextColor(colorsActive[currentPage])
    }

    private fun getItem(i: Int): Int {
        return viewPager!!.currentItem + i
    }

    private fun launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false)
        startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
        finish()
    }

    //  viewpager change listener
    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start))
                btnSkip.setVisibility(View.GONE)
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next))
                btnSkip.setVisibility(View.VISIBLE)
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.TRANSPARENT)
        }
    }

    /**
     * View pager adapter
     */
    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater =
                getSystemService<Any>(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = layoutInflater!!.inflate(layouts[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view: View = `object` as View
            container.removeView(view)
        }
    }
}