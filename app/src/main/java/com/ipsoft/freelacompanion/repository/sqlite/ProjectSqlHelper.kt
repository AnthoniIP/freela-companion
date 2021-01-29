package com.ipsoft.freelacompanion.repository.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
class ProjectSqlHelper(context: Context) : SQLiteOpenHelper(
	context, DATABASE_NAME, null,
	DATABASE_VERSION
) {

	override fun onCreate(db: SQLiteDatabase) {
		db.execSQL(
			"CREATE TABLE $TABLE_PROJECT (" +
					"$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
					"$COLUMN_NAME TEXT NOT NULL," +
					"$COLUMN_DESCRIPTION TEXT," +
					"$COLUMN_DEADLINE TEXT," +
					"$COLUMN_CLIENT TEXT," +
					"$COLUMN_PRICE REAL," +
					"$COLUMN_STATUS INTEGER," +
					"$COLUMN_HOURPERDAY INTEGER," +
					"$COLUMN_DAYDURATION INTEGER)"
		)
	}

	override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
		TODO("Not yet implemented")
	}
}