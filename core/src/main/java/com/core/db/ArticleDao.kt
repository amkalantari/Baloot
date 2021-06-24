package com.core.db

import androidx.room.*
import com.core.dto.ArticleDto


@Dao
interface ArticleDao {

    @Query("delete from article")
    fun removeArticles()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticles(config: ArticleDto) : Long

    @Transaction
    fun insert(config : ArticleDto) : Long {
        removeArticles()
        return insertArticles(config)
    }

    @Query("select * from article")
    fun fetchAll() : List<ArticleDto>

}