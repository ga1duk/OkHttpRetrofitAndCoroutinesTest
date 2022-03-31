package ru.netology.retrofitwithcoroutinestest.repository

import ru.netology.nmedia.error.ApiError
import ru.netology.nmedia.error.NetworkError
import ru.netology.nmedia.error.UnknownError
import ru.netology.retrofitwithcoroutinestest.PostApi
import ru.netology.retrofitwithcoroutinestest.dto.Post
import java.io.IOException

class PostRepositoryImpl : PostRepository {
    override suspend fun getAll(): List<Post> {
        try {
            val response = PostApi.retrofitService.getAll()
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiError(response.code(), response.message())
            return body
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }
    }
}