package com.assign3maulana.app.room.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.assign3maulana.app.room.entity.Student
import io.reactivex.Flowable

/**
 * Created by maulana kavaldo on 15/12/2020.
 */
@Dao
interface StudentDao {
    @Query("SELECT * from students")
    fun getAll(): Flowable<List<Student>>

    @Query("SELECT * FROM students WHERE id = :id ")
    fun getById(id: String): Flowable<Student>

    @Insert(onConflict = REPLACE)
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("UPDATE students SET name =:studentName, nim =:studentNim, gender =:studentGen WHERE id =:studentId")
    fun update(studentId: Long, studentName:String, studentNim:String, studentGen:String)
}