package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_outside_page.*
import org.techtown.drawer.*

class OutFun1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outfun1)

        //토글 만드는방법(개발자가 이렇게 쓰라고 한거임 )
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    val outsideIntent= Intent(this,OutFun1::class.java)
                    startActivity(outsideIntent)
                }
                R.id.item2 -> {
                    val outsideIntent= Intent(this,OutFood1::class.java)
                    startActivity(outsideIntent)
                }
                R.id.item3 -> {
                    val outsideIntent= Intent(this,OutFashion1::class.java)
                    startActivity(outsideIntent)
                }
            }
            //바로가기 메뉴 닫기
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }

    }

    fun onFragmentSelected(index:Int){
        //Fragment1()로 초기화 해줌
        var fragment: Fragment = Fragment1()

        when(index){
            0 -> {
                toolbar.title="내부:첫번째 화면"
                fragment= Fragment4()
            }
            1 ->{
                toolbar.title="내부:두번째 화면"
                fragment= Fragment5()
            }
            2 ->{
                toolbar.title="내부:세번째 화면"
                fragment= Fragment6()
            }
        }
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container,fragment)
        }.commit()


    }
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

}