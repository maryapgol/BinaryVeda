package com.binaryveda.aniket.binaryveda.Contract

import com.binaryveda.aniket.binaryveda.Model.SeekerResponse

/**
 * Created by Aniket on 03-03-2019.
 */
class BaseContract {

    interface View {

        fun displayResponse(seekerResponse: SeekerResponse)

        fun displayProgressDialog()
        fun hideProgressDialog()

    }

    interface Presenter {

        fun seekerResponse(seekerResponse: SeekerResponse)

        fun getSeekerData()

    }

    interface Model {

        fun getSeekerData()


    }

}