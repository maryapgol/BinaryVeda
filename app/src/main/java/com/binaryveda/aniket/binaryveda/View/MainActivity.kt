package com.binaryveda.aniket.binaryveda.View

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.widget.RelativeLayout
import com.binaryveda.aniket.binaryveda.Adapter.SeekerAdapter
import com.binaryveda.aniket.binaryveda.Contract.BaseContract
import com.binaryveda.aniket.binaryveda.Model.SeekerData
import com.binaryveda.aniket.binaryveda.Model.SeekerResponse
import com.binaryveda.aniket.binaryveda.Presenter.MainActivityPresenter
import com.binaryveda.aniket.binaryveda.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.drawable.GradientDrawable
import android.graphics.Color.parseColor
import android.support.design.widget.TabLayout
import android.widget.Toast


class MainActivity : AppCompatActivity(),BaseContract.View {

     private var mainActivityPresenter:MainActivityPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
         toolbar.setNavigationIcon(R.drawable.menu)
        initializeData()

    }

    private fun initializeData() {
        mainActivityPresenter= MainActivityPresenter(this)

      mainActivityPresenter!!.getSeekerData()

        createBackground()

    }

    private fun createBackground() {
        //Color.parseColor() method allow us to convert
        // a hexadecimal color string to an integer value (int color)
        val colors = intArrayOf(Color.parseColor("#1A5D92"), Color.parseColor("#5CCB9D"))

        //create a new gradient color
        val gd = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors)

        gd.cornerRadius = 0f
        //apply the button background to newly created drawable gradient
        scrollviewBackground.setBackground(gd)
    }


    override fun displayResponse(seekerResponse: SeekerResponse) {

        loadSeekerData(seekerResponse.data)

        initializeViewPager(seekerResponse.data)
    }

    private fun initializeViewPager(data: SeekerData?) {

        var stringSkills=""
        var stringFunction=""
        var stringIndustry=""



        data!!.skills!!.forEach {
            stringSkills += "${it.name} | "

        }

        data!!.work_functions!!.forEach {
            stringFunction += "${it.name} | "

        }

        data!!.industries!!.forEach {
            stringIndustry += "${it.name} | "

        }

        var seekerAdapter= SeekerAdapter(supportFragmentManager, stringSkills,stringFunction,stringIndustry,applicationContext)

        viewPager!!.adapter=seekerAdapter

        tabLayout!!.setupWithViewPager(viewPager!!)

        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab!!.position)
                {
                    1->
                        showToast(resources.getString(R.string.seeker_work_function))

                    2->
                        showToast(resources.getString(R.string.seeker_industry))

                }
            }


        })
    }

    private fun showToast(string: String?) {

        Toast.makeText(applicationContext,string,Toast.LENGTH_SHORT).show()
    }

    private fun loadSeekerData(data: SeekerData?) {
        val displaymetrics = DisplayMetrics()

         windowManager.defaultDisplay.getMetrics(displaymetrics)

        /**
         * Consider screen width as 320 and create density to multiply with pixel values
         */
        val width :Double = displaymetrics.widthPixels.toDouble()
        val density:Double=(width/320)
        var imageHeight=85*density
        var imageWidth=85*density


//Create dynamic image
        val small_param = RelativeLayout.LayoutParams(imageWidth.toInt(),imageHeight.toInt())
        small_param.setMargins(20*density.toInt(),30*density.toInt(),0,0)

       //Adding rukes to text besides image
        val small_paramLin = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
        small_paramLin.setMargins(18*density.toInt(),45*density.toInt(),0,0)
        small_paramLin.addRule(RelativeLayout.RIGHT_OF, ivSeeker.id)


        linSeekerData.layoutParams=small_paramLin
        ivSeeker.layoutParams=small_param
        Glide.with(applicationContext).load(data!!.image).asBitmap().crossFade(800).into(ivSeeker)

        //Create height for linear layout
        linDetail.layoutParams.height=80*density.toInt()
        linDetail.requestLayout()
        txtName.text=data.name
        txtdesignation.text=data.designation!!.name
        txtLocation.text=data.location

//Add qualification, ctc, experience

        txtQualification.text=data.highest_qualification!!.name
        txtExperiance.text=data.experience
        txtExpectedctc.text=data.expected_ctc

        txtCurrentWorking.text=data.last_company!!.name
        txtDesignation.text=data.designation.name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
