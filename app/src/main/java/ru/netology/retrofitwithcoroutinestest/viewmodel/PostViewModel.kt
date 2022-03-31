package ru.netology.retrofitwithcoroutinestest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.netology.retrofitwithcoroutinestest.dto.Post
import ru.netology.retrofitwithcoroutinestest.repository.PostRepository
import ru.netology.retrofitwithcoroutinestest.repository.PostRepositoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryImpl()
    private val _data = MutableLiveData<List<Post>>()
    val data: LiveData<List<Post>>
    get() = _data

    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
       _data.value = repository.getAll()
    }
}