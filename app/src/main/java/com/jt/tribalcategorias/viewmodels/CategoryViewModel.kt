package com.jt.tribalcategorias.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jt.domain.service.CategoryService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryService: CategoryService): ViewModel() {

    private val _categoryList: MutableStateFlow<List<String>?> = MutableStateFlow(null)
    val categoryList: StateFlow<List<String>?> get() = _categoryList

    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                categoryService.getCategory().collectLatest { category ->
                    _categoryList.value = category
                }
            }catch (exception: Exception){
                _categoryList.value = null
            }
        }
    }
}