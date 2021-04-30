package com.codility.parsegson

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codility.parsegson.api.API
import com.codility.parsegson.model.Bean
import com.codility.recyclerview.MyAdapter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private var API_URL = "http://192.168.1.31/json/json_array_gson.json";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            DisplayJsonWithGson().execute()
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class DisplayJsonWithGson : AsyncTask<ArrayList<Bean>, String, ArrayList<Bean>>() {

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: ArrayList<Bean>?): ArrayList<Bean> {
            val result: String = API.getData(API_URL)
            // Parse Json ArrayList Using GSON library
            val listType = object : TypeToken<ArrayList<Bean>>() {}.type
            val beanArrayList: ArrayList<Bean> = GsonBuilder().create().fromJson(result, listType)
            // return ArrayList
            return beanArrayList
        }

        override fun onPostExecute(result: ArrayList<Bean>?) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE
            // Set ArrayList in RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            val myAdapter = MyAdapter(result!!)
            recyclerView.adapter = myAdapter
            tvLoading.visibility = View.GONE
        }
    }
}