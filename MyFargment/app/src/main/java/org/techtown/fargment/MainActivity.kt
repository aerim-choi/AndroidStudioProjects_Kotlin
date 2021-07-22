package org.techtown.fargment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var loginFragment:LoginFragment= LoginFragment()
    var menuFragment:MenuFragment= MenuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoginButton.setOnClickListener {
            //Transaction은 함수가 한꺼번에 작동할수있도록 하는거
           //supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment()).commit()
           /* with(supportFragmentManager.beginTransaction()){
                replace(R.id.container,LoginFragment())
            }.commit()
            */
//            with(supportFragmentManager.beginTransaction()){
//                replace(R.id.container,loginFragment)
//            }.commit()
            onFragmentChanged(0)
        }
        showMenuButton.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container,MenuFragment()).commit()
//            with(supportFragmentManager.beginTransaction()){
//                replace(R.id.container,menuFragment)
//            }.commit()
            onFragmentChanged(1)
        }
    }
    fun onFragmentChanged(index:Int){
        when(index){
            0->{
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,loginFragment)
                }.commit()
            }
            1->{
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,menuFragment)
                }.commit()
            }
        }
    }
}