package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {
    private val COMMON_TAG = "CombinedLifeCycle"
    private val ACTIVITY_NAME = MainActivity::class.java.simpleName
    private val TAG = COMMON_TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "$ACTIVITY_NAME onCreate");
    }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "$ACTIVITY_NAME onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "$ACTIVITY_NAME onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "$ACTIVITY_NAME onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "$ACTIVITY_NAME onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "$ACTIVITY_NAME onDestroy")
    }


    fun selectFragment(view: View) {
        val fr: Fragment = if (view === findViewById<View>(R.id.button1)) {
            FragmentOne()
        } else if (view === findViewById<View>(R.id.button2)){
            FragmentTwo()
        } else{
            FragmentThree()
        }
        if(fr is FragmentOne )
            Log.i(TAG, "$ACTIVITY_NAME fragment")

        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_section, fr)
        fragmentTransaction.addToBackStack("fragmentStack")
        fragmentTransaction.commit()
        Log.i(TAG, "$fr")
    }
}


