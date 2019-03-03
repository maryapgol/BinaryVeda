package com.binaryveda.aniket.binaryveda.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.binaryveda.aniket.binaryveda.Contract.BaseContract
import com.binaryveda.aniket.binaryveda.Model.SeekerResponse
import com.binaryveda.aniket.binaryveda.Presenter.MainActivityPresenter
import com.binaryveda.aniket.binaryveda.R
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


    }
}
