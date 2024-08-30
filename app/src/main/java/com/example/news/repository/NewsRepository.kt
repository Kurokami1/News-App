package com.example.news.repository

import com.example.news.api.RetrofitInstance
import com.example.news.database.ArticleDataBase
import com.example.news.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getHeadLines(countryCode: String, pageNumber: Int)=
        RetrofitInstance.api.getHeadLines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
    suspend fun upsert(article: Article)= db.getArticleDAO().upsert(article)

    fun getFavoriteNews()= db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article)= db.getArticleDAO().deleteArticle(article)

}