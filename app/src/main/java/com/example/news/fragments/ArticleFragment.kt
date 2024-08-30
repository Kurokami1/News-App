package com.example.news.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.news.R
import com.example.news.databinding.FragmentArticleBinding
import com.example.news.ui.NewsActivity
import com.example.news.ui.NewsViewModels
import com.google.android.material.snackbar.Snackbar

private lateinit var binding: FragmentArticleBinding
class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var newsViewModels: NewsViewModels
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentArticleBinding.bind(view)
        newsViewModels = (activity as NewsActivity).newsViewModels
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }

            binding.fab.setOnClickListener {
                newsViewModels.addToFavorites(article)
                Snackbar.make(view, "Added to favorites", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}