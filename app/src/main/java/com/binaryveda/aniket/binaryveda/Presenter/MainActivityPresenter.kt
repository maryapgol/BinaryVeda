package com.binaryveda.aniket.binaryveda.Presenter

import com.binaryveda.aniket.binaryveda.Contract.BaseContract
import com.binaryveda.aniket.binaryveda.Model.MainActivityModel
import com.binaryveda.aniket.binaryveda.Model.SeekerResponse

/**
 * Created by Aniket on 03-03-2019.
 */
class MainActivityPresenter(var view:BaseContract.View):BaseContract.Presenter {

  private var mainActivityModel:MainActivityModel?=null

    override fun getSeekerData() {
        view.displayProgressDialog()
      mainActivityModel= MainActivityModel(this)
         mainActivityModel!!.getSeekerData()

    }

    override fun seekerResponse(seekerResponse: SeekerResponse) {
        view.hideProgressDialog()
       view.displayResponse(seekerResponse)

    }




}