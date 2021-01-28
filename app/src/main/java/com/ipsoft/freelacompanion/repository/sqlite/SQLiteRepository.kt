package com.ipsoft.freelacompanion.repository.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.data.model.ProjectStatus
import com.ipsoft.freelacompanion.repository.ProjectRepository

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
class SQLiteRepository(ctx: Context) : ProjectRepository {

	private val helper: ProjectSqlHelper = ProjectSqlHelper(ctx)
	private fun insert(project: Project) {
		val status = when (project.status) {
			ProjectStatus.STARTED -> 1
			ProjectStatus.PAUSED -> 2
			ProjectStatus.CANCELED -> 3
			ProjectStatus.FINISHED -> 4
		}
		val db = helper.writableDatabase
		val cv = ContentValues().apply {
			put(COLUMN_NAME, project.name)
			put(COLUMN_DESCRIPTION, project.description)
			put(COLUMN_DESCRIPTION, project.description)
			put(COLUMN_DEADLINE, project.deadLine)
			put(COLUMN_CLIENT, project.client)
			put(COLUMN_PRICE, project.price)
			put(COLUMN_STATUS, status)
			put(COLUMN_DAYDURATION, project.dayDuration)
		}
		val id = db.insert(TABLE_PROJECT, null, cv)
		if (id != -1L) {
			project.id = id
		}
		db.close()
	}

	private fun update(project: Project) {
		val status = when (project.status) {
			ProjectStatus.STARTED -> 1
			ProjectStatus.PAUSED -> 2
			ProjectStatus.CANCELED -> 3
			ProjectStatus.FINISHED -> 4
		}
		val db = helper.writableDatabase
		val cv = ContentValues().apply {
			put(COLUMN_ID, project.id)
			put(COLUMN_NAME, project.name)
			put(COLUMN_DESCRIPTION, project.description)
			put(COLUMN_DESCRIPTION, project.description)
			put(COLUMN_DEADLINE, project.deadLine)
			put(COLUMN_CLIENT, project.client)
			put(COLUMN_PRICE, project.price)
			put(COLUMN_STATUS, status)
			put(COLUMN_DAYDURATION, project.dayDuration)
		}
		db.insertWithOnConflict(
			TABLE_PROJECT,
			null,
			cv,
			SQLiteDatabase.CONFLICT_REPLACE
		)
		db.close()
	}

	override fun save(project: Project) {
		if (project.id != 0L) {
			insert(project)
		} else {
			update(project)
		}
	}

	override fun remove(vararg projects: Project) {
		val db = helper.writableDatabase
		for (projeto in projects) {
			db.delete(
				TABLE_PROJECT,
				"$COLUMN_ID = ?",
				arrayOf(projeto.id.toString())
			)
			db.close()
		}
	}

	override fun projectById(id: Long, callback: (Project?) -> Unit) {
		val sql = "SELECT * FROM $TABLE_PROJECT WHERE $COLUMN_ID = ?"
		val db = helper.readableDatabase
		val cursor = db.rawQuery(sql, arrayOf(id.toString()))
		val project = if (cursor.moveToNext()) projectFromCursor(cursor) else null
		callback(project)
	}

	override fun search(term: String, callback: (List<Project>) -> Unit) {
		var sql = "SELECT * FROM $TABLE_PROJECT"
		var args: Array<String>? = null
		if (term.isNotEmpty()) {
			sql += " WHERE $COLUMN_NAME LIKE ?"
			args = arrayOf("%$term%")
		}
		sql += " ORDER BY $COLUMN_NAME"
		val db = helper.readableDatabase
		val cursor = db.rawQuery(sql, args)
		val projects = ArrayList<Project>()
		while (cursor.moveToNext()) {
			val project = projectFromCursor(cursor)
			projects.add(project)
		}
		cursor.close()
		db.close()
		callback(projects)
	}

	private fun projectFromCursor(cursor: Cursor): Project {
		val id = cursor.getLong(
			cursor.getColumnIndex(COLUMN_ID)
		)
		val name = cursor.getString(
			cursor.getColumnIndex(COLUMN_NAME)
		)
		val price = cursor.getDouble(
			cursor.getColumnIndex(COLUMN_PRICE)
		)
		val description = cursor.getString(
			cursor.getColumnIndex(COLUMN_DESCRIPTION)
		)
		val deadLine = cursor.getString(
			cursor.getColumnIndex(COLUMN_DEADLINE)
		)
		val client = cursor.getString(
			cursor.getColumnIndex(COLUMN_CLIENT)
		)
		val status = cursor.getInt(
			cursor.getColumnIndex(COLUMN_STATUS)
		)
		var projectStatus = when (status) {
			1 -> ProjectStatus.STARTED
			2 -> ProjectStatus.PAUSED
			3 -> ProjectStatus.CANCELED
			4 -> ProjectStatus.FINISHED
			else -> ProjectStatus.STARTED
		}
		val hourPerDay = cursor.getInt(
			cursor.getColumnIndex(COLUMN_HOURPERDAY)
		)
		val dayDuration = cursor.getInt(
			cursor.getColumnIndex(COLUMN_DAYDURATION)
		)


		return Project(
			id,
			name,
			description,
			deadLine,
			client,
			price,
			projectStatus,
			hourPerDay,
			dayDuration
		)
	}
}