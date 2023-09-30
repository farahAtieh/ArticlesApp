package com.frhatieh.articlesapp.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.data.model.Article
import com.frhatieh.articlesapp.domain.usecases.FetchPopularViewedArticlesUseCase
import com.frhatieh.articlesapp.domain.usecases.GetPopularViewedArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getPopularViewedArticlesUseCase: GetPopularViewedArticlesUseCase,
    private val fetchPopularViewedArticlesUseCase: FetchPopularViewedArticlesUseCase
) : ViewModel() {

    private var articlesList: List<Article> = mutableListOf()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private val _uiState: MutableStateFlow<ArticlesUiState> =
        MutableStateFlow(ArticlesUiState.Loading)
    val uiState: StateFlow<ArticlesUiState> get() = _uiState.asStateFlow()

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            getPopularViewedArticlesUseCase()
                .collectLatest { articles: List<Article> ->
                    if (articles.isNotEmpty()) {
                        articlesList = articles
                        _uiState.update {
                            ArticlesUiState.Success(articles = articles)
                        }
                    } else {
                        fetchArticles()
                    }
                }
        }

    }

    private fun fetchArticles(isForeRefreshing: Boolean = false) {
        if(isForeRefreshing){
            _isRefreshing.value = true
        }else{
            _uiState.update {
                ArticlesUiState.Loading
            }
        }

        viewModelScope.launch {
            fetchPopularViewedArticlesUseCase().collectLatest { response ->
                response.onFailure { error ->
                    val errorMessageId = when (error) {
                        is UnknownHostException -> R.string.network_error
                        else -> R.string.error_fetching_new_articles
                    }
                    _uiState.update {
                        ArticlesUiState.Error(errorMessageId = errorMessageId)
                    }
                }

            }
            _isRefreshing.value = false
        }
    }

    fun refresh(){
        fetchArticles(true)
    }
    fun search(query: String) {
        viewModelScope.launch {
            delay(1500)
            _uiState.update {
                ArticlesUiState.Success(articles = articlesList.filter {
                    it.title.contains(query)
                })
            }
        }
    }

    fun sort(isSorted: Boolean) {
        viewModelScope.launch {
            _uiState.update {
                ArticlesUiState.Success(
                    articles =
                    if (isSorted) {
                        articlesList.sortedByDescending {
                            it.publishedDate
                        }
                    } else {
                        articlesList
                    }
                )
            }
        }


    }
}