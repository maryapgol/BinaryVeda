package com.binaryveda.aniket.binaryveda.Model.Network

import com.binaryveda.aniket.binaryveda.Helper.Constants
import com.binaryveda.aniket.binaryveda.Model.SeekerResponse
import com.github.simonpercic.oklog3.OkLogInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.http.GET
import retrofit2.http.Headers


/**
 * Created by Aniket on 03-03-2019.
 */
interface RestClient {

    @Headers("$key: $value")

    @GET("1.0/profiles/74")
    fun getSeekerResponse(): Call<SeekerResponse>

    companion object {

         const val key = "Authorization"
         const  val value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjdiYmZlNTI4YjI5OWVhOGZjNTg4OWM3N2M5NWZjMDliOGVmNmI0NGNiN2QyMTg4NzIxMWIxYjFjMTRjOTdhYjg4NGViNjQ2MTlhZWRjY2RiIn0.eyJhdWQiOiIzIiwianRpIjoiN2JiZmU1MjhiMjk5ZWE4ZmM1ODg5Yzc3Yzk1ZmMwOWI4ZWY2YjQ0Y2I3ZDIxODg3MjExYjFiMWMxNGM5N2FiODg0ZWI2NDYxOWFlZGNjZGIiLCJpYXQiOjE1NTEwMTEwMDcsIm5iZiI6MTU1MTAxMTAwNywiZXhwIjoxNTgyNTQ3MDA3LCJzdWIiOiIxOTMiLCJzY29wZXMiOltdfQ.enC6mmwbQPNgociOwaJbuWeGIL0v5t_54_cFyq-4UF-GkL6qiPHN0iTzwoVn3dT8SYO3zQoHF9ZiDNZt1HsdMowPp0qDS48OYC1yOk4jjMJpm6bG3a14dBT5C_lbutJxR1Hy64KZSM0AZDBQVI6wSBVsUX9PB5NO96bkaOfoojIFln5hJoszTe38ipurz0aFKfV-EN1lRT4WH603q7vAuepPWDy9-XrTEh13MrYBte6ioP0Jfspeoe35Kfv-0S0965tBTCzOzSHjEnPDAP8f3pjgqcrVk_RnEzibcI50A-DiZxjtuRJhzS8_KFfSoBiicbBaW-aTsU0VX2RM2ZLZ4sfgCsW_hm_8DLIfZBDySjS29uwjiRL1Z8gXYgr4fKw9xqGAKvTPcAqeDpDxgyeaS5tJI0R-x_PLl40dIWZPomymtF75QEOv_OwgLLvuFdY7Hu7lfe8q3RKYcr5g4dt4HYlJq1h4F1UyRowAcZXLTk5lCHzv1-KzKbeZ5ZfpkxzyIOQsP5xVDZDo0RMQ2aC7Jt000k8jkpH5DtkAR40G_mh7ffcNgpIQAFYIxXC7dAn6FVPiIv1o-xweRQa1P1j9AffpEABo6eYrrGFIihok5qOkLm4dSwUAnxB-Kfa0doz-7JJmzDTRH6zCsyvYl2oysHuXTesn1rieFFDThDErq3Q"


        fun create(): RestClient {

            val okLogInterceptor = OkLogInterceptor.builder().build()
            val okHttpBuilder = OkHttpClient.Builder()


            okHttpBuilder.connectTimeout(10, TimeUnit.SECONDS)
            okHttpBuilder.readTimeout(10, TimeUnit.SECONDS).build()
            okHttpBuilder.writeTimeout(10, TimeUnit.SECONDS)

            okHttpBuilder.addInterceptor(okLogInterceptor)
            //okHttpBuilder.addInterceptor(okLogInterceptor)
            val okHttpClient = okHttpBuilder.build()
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Constants.DOMAIN)
                    .client(okHttpClient)
                    .build()
            return retrofit.create(RestClient::class.java)
        }

    }



}