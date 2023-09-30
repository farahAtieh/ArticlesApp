package com.frhatieh.articlesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.frhatieh.articlesapp.data.model.ArticleEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticlesDao {
    @Query("SELECT * FROM ArticleTable")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArticles(articles: List<ArticleEntity>)

    @Query("DELETE FROM ArticleTable")
    fun clearAll()
}