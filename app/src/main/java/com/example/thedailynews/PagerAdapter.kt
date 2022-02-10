package com.example.thedailynews

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    private val tabcount = 6

    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> NewsFragment()
            2 -> ElectionFragment()
            3 -> CryptoFragment()
            4 -> SportsFragment()
            5 -> EntertainmentFragment()
            else -> HomeFragment()
        }
    }
}