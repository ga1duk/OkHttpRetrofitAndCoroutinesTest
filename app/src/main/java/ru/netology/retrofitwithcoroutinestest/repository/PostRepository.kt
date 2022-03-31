package ru.netology.retrofitwithcoroutinestest.repository

import ru.netology.retrofitwithcoroutinestest.dto.Post

interface PostRepository {
    suspend fun getAll(): List<Post>
}