package com.assign3maulana.app.room.db.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.assign3maulana.app.room.db.StudentDao
import com.assign3maulana.app.room.entity.Student
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by maulana kavaldo on 15/12/2020.
 */
class LocalRepository @Inject constructor(studentDao: StudentDao, compositeDisposable: CompositeDisposable) {

    var stDao : StudentDao = studentDao
    var comp : CompositeDisposable = compositeDisposable

    fun getAllData() : LiveData<List<Student>>{
        return LiveDataReactiveStreams.fromPublisher(stDao.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation()))
    }

    fun insertData(student: Student){
        comp.add(Observable.fromCallable {stDao.insert(student)}
                .subscribeOn(Schedulers.computation())
                .subscribe())
    }

    fun getDataById(id: String): LiveData<Student>{
        return LiveDataReactiveStreams.fromPublisher(stDao.getById(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation()))
    }

    fun deleteData(student: Student){
        comp.add(Observable.fromCallable { stDao.delete(student) }
                .subscribeOn(Schedulers.computation())
                .subscribe())
    }

    fun updateData(id: Long, name: String, nim: String, gen: String){
        comp.add(Observable.fromCallable { stDao.update(id, name, nim, gen) }
                .subscribeOn(Schedulers.computation())
                .subscribe())
    }

}