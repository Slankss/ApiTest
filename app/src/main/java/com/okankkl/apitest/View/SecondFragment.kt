package com.okankkl.apitest.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.apitest.Adapter.ApiAdapter
import com.okankkl.apitest.Adapter.UniversityAdapter
import com.okankkl.apitest.Model.University
import com.okankkl.apitest.R
import com.okankkl.apitest.Service.UniversityApi
import io.reactivex.disposables.CompositeDisposable
import com.okankkl.apitest.databinding.FragmentSecondBinding
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding

    private val BASE_URL=  "http://universities.hipolabs.com/"
    private var universityList = ArrayList<University>()
    private lateinit var recyclerViewAdapter : UniversityAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar2.visibility = View.VISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)



        return binding.root
    }

    fun loadData(){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(UniversityApi::class.java)
        val call = service.getData()

        call.enqueue(object : retrofit2.Callback<List<University>> {
            override fun onResponse(
                call: Call<List<University>>,
                response: Response<List<University>>
            ) {
                if(response.isSuccessful){
                    binding.progressBar2.visibility = View.GONE
                    response.body()?.let {
                        universityList = ArrayList(it)

                        context?.let {
                            val layoutManager = LinearLayoutManager(it)
                            binding.recyclerView.layoutManager = layoutManager
                            recyclerViewAdapter= UniversityAdapter(universityList)
                            binding.recyclerView.adapter = recyclerViewAdapter
                        }

                    }
                }
            }

            override fun onFailure(call: Call<List<University>>, t: Throwable) {
                Toast.makeText(context,"Veriler Yüklenmedi",Toast.LENGTH_LONG).show()
                println(t.localizedMessage)
            }
        })

    }



}