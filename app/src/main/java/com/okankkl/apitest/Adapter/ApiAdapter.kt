package com.okankkl.apitest.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.apitest.Model.API
import com.okankkl.apitest.databinding.ApiListRecyclerRowBinding

class ApiAdapter(private var apiList: ArrayList<API>)
    : RecyclerView.Adapter<ApiAdapter.apiViewHolder>() {

    class apiViewHolder(val apiListBinding: ApiListRecyclerRowBinding)
        : RecyclerView.ViewHolder(apiListBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): apiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val apiListBinding = ApiListRecyclerRowBinding.inflate(layoutInflater, parent, false)
        return apiViewHolder(apiListBinding)
    }

    override fun onBindViewHolder(holder: apiViewHolder, position: Int) {
        val api = apiList[position]

        holder.apiListBinding.apply {
            txtApiName.text = api.apiName
            txtApiDescription.text = api.apiDescription
            txtApiLink.text = "Link : "+api.apiLink
        }
    }

    override fun getItemCount(): Int {
        return apiList.size
    }


}