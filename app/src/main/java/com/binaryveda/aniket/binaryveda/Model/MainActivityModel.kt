package com.binaryveda.aniket.binaryveda.Model

import android.app.Activity
import android.util.Log
import com.binaryveda.aniket.binaryveda.Contract.BaseContract
import com.binaryveda.aniket.binaryveda.Model.Network.RestClient
import com.binaryveda.aniket.binaryveda.Presenter.MainActivityPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Aniket on 03-03-2019.
 */
class MainActivityModel(var presenter:MainActivityPresenter):BaseContract.Model {

 private val TAG="MainActivityModel"

    override fun getSeekerData() {

    var  call= RestClient.create().getSeekerResponse()


        call.enqueue(object : Callback<SeekerResponse> {
            override fun onResponse(call: Call<SeekerResponse>, response: Response<SeekerResponse>) {

               var seekerResponse=response.body()

           presenter.seekerResponse(seekerResponse!!)
                Log.i(TAG,"Response :"+seekerResponse)
            }

            override fun onFailure(call: Call<SeekerResponse>, t: Throwable) {

            }
        })

    }


}

