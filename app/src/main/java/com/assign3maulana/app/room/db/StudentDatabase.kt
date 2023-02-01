package com.assign3maulana.app.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assign3maulana.app.room.entity.Student

/**
 * Created by maulana kavaldo on 15/12/2020.
 */
@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}