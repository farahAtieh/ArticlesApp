package com.frhatieh.articlesapp.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.data.model.Article
import com.frhatieh.articlesapp.presentation.component.LoadingScreen
import com.frhatieh.articlesapp.presentation.component.SearchTextField
import com.frhatieh.articlesapp.util.extensions.formatDateToDaysAgo
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsState().value
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = viewModel::refresh,
    ) {
        when (state) {
            is ArticlesUiState.Error -> {
                Text(text = stringResource(id = state.errorMessageId))
            }

            ArticlesUiState.Loading -> {
                LoadingScreen()
            }

            is ArticlesUiState.Success -> {
                Dashboard(
                    state.articles,
                    viewModel::search,
                    viewModel::sort
                )
            }

        }
    }
}

@Composable
fun Dashboard(
    articles: List<Article>,
    searchForArticles: (String) -> Unit,
    sortArticles: (Boolean) -> Unit
) {
    var isSorted by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(id = R.string.articles))
            Row {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_sort),
                    contentDescription = null
                )
                Text(text = stringResource(id = R.string.sort),
                    fontWeight = if (isSorted) FontWeight.Bold else FontWeight.Normal,
                    textDecoration = if (isSorted) TextDecoration.Underline else null,
                    modifier = Modifier
                        .padding(2.dp)
                        .clickable {
                            isSorted = !isSorted
                            sortArticles(isSorted)
                        })
            }
        }

        SearchTextField(searchQuery) {
            searchQuery = it
            searchForArticles(searchQuery)
        }

        ArticlesDashboard(articles)

    }
}


@Composable
fun ArticlesDashboard(articles: List<Article>) {

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(articles) { article ->
            DashboardRow(article)
        }
    }
}

@Composable
fun DashboardRow(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Image(
            painter = rememberCoilPainter(
                request = article.imageUrl.ifBlank {
                    R.drawable.articles
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(20.dp)),
        )

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {

            Text(
                text = article.title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Text(text = article.publishedDate.formatDateToDaysAgo(LocalContext.current))
        }
    }

}

