package com.example.listviews.Lists

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import com.example.listviews.R


class BlankFragment : Fragment() {
    private val TAG = "FragmentLifecycle"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreateFrag")

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach(Context)")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateViewFrag")

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStartFrag")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResumeFrag")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPauseFrag")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStopFrag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyViewFrag")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroyFrag")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }




}