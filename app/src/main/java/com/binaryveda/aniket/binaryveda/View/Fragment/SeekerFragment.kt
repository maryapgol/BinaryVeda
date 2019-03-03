package com.binaryveda.aniket.binaryveda.View.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.binaryveda.aniket.binaryveda.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SeekerFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SeekerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeekerFragment : Fragment() {

    private var data:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            data = arguments.getString(DATA)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_seeker, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         view!!.findViewById<TextView>(R.id.txtData).text=data
    }

    companion object {

        private val DATA = "data"

        fun newInstance(data: String): SeekerFragment {
            val fragment = SeekerFragment()
            val args = Bundle()
            args.putString(DATA,data)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
