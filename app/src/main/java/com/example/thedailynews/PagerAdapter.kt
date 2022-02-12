package com.example.thedailynews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    private val tabcount = 6

    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> HealthFragment()
            2 -> TechnologyFragment()
            3 -> BusinessFragment()
            4 -> SportsFragment()
            5 -> EntertainmentFragment()
            else -> HomeFragment()
        }
    }
}