package com.example.thedailynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val api: String = "cc14586d925f451d838347dfebcd93e7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val pageradapter = PagerAdapter(supportFragmentManager)
        fragmenthoder.adapter = pageradapter
        fragmenthoder.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                fragmenthoder.currentItem = tab!!.position
                if (tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5){
                    pageradapter.notifyDataSetChanged()
                }
                }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


        })
    }
}