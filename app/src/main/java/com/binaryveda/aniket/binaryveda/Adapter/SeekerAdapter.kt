package com.binaryveda.aniket.binaryveda.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.binaryveda.aniket.binaryveda.R
import com.binaryveda.aniket.binaryveda.View.Fragment.SeekerFragment
import android.content.Context
import com.binaryveda.aniket.binaryveda.Helper.Constants

/**
 * Created by Aniket on 03-03-2019.
 */
class SeekerAdapter (fm: FragmentManager,var skills: String?,var work_functions: String?,var industries: String?,var context:Context) : FragmentPagerAdapter(fm) {

    val TAG: String = "SeekerAdapter"


var fragment:Fragment?=null
    override fun getItem(position: Int): Fragment {

        when (position) {


            SKILL -> {
                fragment=SeekerFragment.newInstance(skills!!,Constants.SKILL)

            }

            WORK_FUNCTION -> {

                fragment=SeekerFragment.newInstance(work_functions!!,Constants.WORK_FUNCTION)

            }

            INDUSTRIES -> {
                fragment=SeekerFragment.newInstance(industries!!,Constants.INDUSTRY)


            }

        }

        return   fragment!!

    }

    companion object {
        private val SKILL = 0
        private val WORK_FUNCTION = 1
        private val INDUSTRIES = 2

        private val TABS = intArrayOf(SKILL, WORK_FUNCTION, INDUSTRIES)
    }
    override fun getCount(): Int {


        return TABS.size
    }

    override fun getPageTitle(position: Int): CharSequence {

        var title:String?=null
        when (position) {
            0 -> {

                title=context.getString(R.string.skill_set)
            }

            1 -> {

                title=context.getString(R.string.work_function)

            }
            2 -> {

                title=context.getString(R.string.industry)

            }

        }

        return title!!
    }

}