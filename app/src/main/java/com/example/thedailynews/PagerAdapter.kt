package com.example.thedailynews

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(private val context: Context, fragmentManager: FragmentManager, internal var tabcount: Int): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1 -> return NewsFragment()
            2 -> return ElectionFragment()
            3 -> return CryptoFragment()
            4 -> return SportsFragment()
            5 -> return EntertainmentFragment()
            else -> return HomeFragment()
        }
    }
}