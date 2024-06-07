package com.jt.tribalcategorias.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jt.tribalcategorias.R
import com.jt.tribalcategorias.adapter.CategoryAdapter
import com.jt.tribalcategorias.viewmodels.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private var categoryList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        observerViewModel()
        initUI()
    }

    private fun initViewModel(){
        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        categoryViewModel.getCategory()
    }

    private fun observerViewModel(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                categoryViewModel.categoryList.collectLatest { categoryList ->
                    categoryList?.let {
                        processCategory(it)
                    }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun processCategory(category: List<String>) {
        this.categoryList.apply {
            clear()
            addAll(category)
        }
        categoryAdapter.notifyDataSetChanged()
    }

    private fun initUI(){
        val categoryRecyclerView: RecyclerView = findViewById(R.id.category_recyclerview)
        categoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL,false)
            categoryAdapter = CategoryAdapter(categoryList)
            adapter = categoryAdapter
        }
    }
}