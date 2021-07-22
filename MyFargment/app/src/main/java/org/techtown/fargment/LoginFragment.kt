package org.techtown.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView=inflater.inflate(R.layout.fragment_login, container, false)

        rootView.nextButton.setOnClickListener {
            val mainActivity=activity as MainActivity
            mainActivity.onFragmentChanged(1)
        }
        return rootView
    }
}