package com.ipsoft.freelacompanion.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ipsoft.freelacompanion.data.db.dao.ProjectDao
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.repository.DATABASE_NAME
import com.ipsoft.freelacompanion.repository.DATABASE_VERSION

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       16/02/2021
 */
@Database(entities = [ProjectEntity::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract val projectDao: ProjectDao

    companion object {

        private val INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
                return instance
            }
        }
    }
}