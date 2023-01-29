package com.example.foody.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.foody.R
import com.example.foody.models.ApiResult
import kotlinx.android.synthetic.main.fragment_i_n_s_t_r_u_c_t_i_o_n_s.view.*


class InstructionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_i_n_s_t_r_u_c_t_i_o_n_s, container, false)
        val args = arguments
        val myBundle: ApiResult? = args?.getParcelable(Constants.RECIPES_RESULT_KEY)

        view.instructions_webView.webViewClient = object : WebViewClient() {}
        val websiteUrl: String = myBundle!!.sourceUrl
        view.instructions_webView.loadUrl(websiteUrl)

        return view
    }

}