package com.core.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.core.dto.ConfigEntity


@Dao
interface ConfigDao {

    @Query("delete from config")
    fun removeConfigs()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertConfigs(config: ConfigEntity) : Long

    @Update
    fun updateConfigs(config: ConfigEntity)

    @Transaction
    fun insert(config : ConfigEntity) : Long {
        removeConfigs()
        return insertConfigs(config)
    }

    @Query("select * from config")
    fun fetchAll() : List<ConfigEntity>

    @Query("select * from config limit 1")
    fun fetchConfig() : LiveData<ConfigEntity>
}