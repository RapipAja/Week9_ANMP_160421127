package com.ubaya.todoapp.util

import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ubaya.todoapp.model.TodoDatabase

val DB_NAME = "newtododb"
val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 not null")
    }

}

fun buildDb(context: Context): TodoDatabase {
    val db = TodoDatabase.buildDatabase(context)
    return db
}