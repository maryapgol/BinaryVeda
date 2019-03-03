package com.binaryveda.aniket.binaryveda.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.RelativeLayout
import com.binaryveda.aniket.binaryveda.Contract.BaseContract
import com.binaryveda.aniket.binaryveda.Model.SeekerData
import com.binaryveda.aniket.binaryveda.Model.SeekerResponse
import com.binaryveda.aniket.binaryveda.Presenter.MainActivityPresenter
import com.binaryveda.aniket.binaryveda.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BaseContract.View {

     private var mainActivityPresenter:MainActivityPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initializeData()

    }

    private fun initializeData() {
        mainActivityPresenter= MainActivityPresenter(this)

      mainActivityPresenter!!.getSeekerData()

    }


    override fun displayResponse(seekerResponse: SeekerResponse) {

        loadSeekerData(seekerResponse.data)
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



        val small_param = RelativeLayout.LayoutParams(imageWidth.toInt(),imageHeight.toInt())
        small_param.setMargins(20*density.toInt(),30*density.toInt(),0,0)

        val small_paramLin = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
        small_paramLin.setMargins(18*density.toInt(),45*density.toInt(),0,0)
        small_paramLin.addRule(RelativeLayout.RIGHT_OF, ivSeeker.id)


        linSeekerData.layoutParams=small_paramLin
        ivSeeker.layoutParams=small_param
        Glide.with(applicationContext).load(data!!.image).asBitmap().crossFade(800).into(ivSeeker)

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


}
