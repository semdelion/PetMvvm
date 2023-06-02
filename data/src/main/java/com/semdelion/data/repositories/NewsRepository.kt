package com.semdelion.data.repositories

import com.semdelion.data.services.BaseService
import com.semdelion.data.services.interfaces.NewsServices
import com.semdelion.data.services.models.NewsModel
import com.semdelion.domain.models.News
import com.semdelion.domain.repositories.INewsRepository

class NewsRepository(): BaseService(), INewsRepository {

    private val newsServices = BaseService.retrofit.create(NewsServices::class.java)

    override fun getNews(): List<News> {

        val response = newsServices.getNews().execute()

        val newsModel = response.body()?.results ?: mutableListOf()

        val news:MutableList<News> = mutableListOf()
        newsModel.forEach { news.add( News(
            title = it.title,
            link = it.link,
            creator = it.creator ?: listOf(),
            videoURL = it.videoURL ?: "",
            description = it.description ?:"",
            content = it.content ?: "",
            pubDate = it.pubDate,
            imageURL = it.imageURL ?: "",
        )) }
        return news
    }
}