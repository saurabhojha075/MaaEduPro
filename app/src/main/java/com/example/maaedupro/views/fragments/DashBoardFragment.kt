package com.example.maaedupro.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maaedupro.R

class DashBoardFragment: BaseOrderFragment() {

    //Companion object if single instance of fragment is to be maintained
    companion object {
        fun newInstance(args: Bundle?): DashBoardFragment{
            val fragment = DashBoardFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

}