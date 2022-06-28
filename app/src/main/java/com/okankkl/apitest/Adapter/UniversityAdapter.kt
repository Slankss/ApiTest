package com.okankkl.apitest.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.apitest.Model.API
import com.okankkl.apitest.Model.University
import com.okankkl.apitest.databinding.ApiListRecyclerRowBinding
import com.okankkl.apitest.databinding.UniversityListRecyclerRowBinding

class UniversityAdapter(private var universityList: ArrayList<University>)
    : RecyclerView.Adapter<UniversityAdapter.apiViewHolder>() {

    class apiViewHolder(val universityListBinding: UniversityListRecyclerRowBinding)
        : RecyclerView.ViewHolder(universityListBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): apiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val universityListBinding = UniversityListRecyclerRowBinding.inflate(layoutInflater, parent, false)
        return apiViewHolder(universityListBinding)
    }

    override fun onBindViewHolder(holder: apiViewHolder, position: Int) {
        val api = universityList[position]
        println(position)
        holder.universityListBinding.apply {
            println(api.name+"||"+api.domains.get(0))

            txtUniversityName.text = api.name
            txtUniversityDomain.text = api.domains.get(0)
        }
    }

    override fun getItemCount(): Int {
        return universityList.size
    }


}