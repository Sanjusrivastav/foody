package com.example.foody.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foody.R
import com.example.foody.models.ApiResult
import com.example.foody.ui.fragments.Constants.Companion.RECIPES_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_i_n_g_r_e_d_i_e_n_t_s.view.*


class IngredientsFragment : Fragment() {

    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val view =  inflater.inflate(R.layout.fragment_i_n_g_r_e_d_i_e_n_t_s, container, false)
        val args = arguments
        val myBundle: ApiResult? = args?.getParcelable(RECIPES_RESULT_KEY)

        setupRecyclerView(view)
        myBundle?.extendedIngredients?.let { mAdapter.setData(it) }

        return view
    }

    private fun setupRecyclerView(view: View) {
        view.ingredients_recyclerview.adapter = mAdapter
        view.ingredients_recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }


}

