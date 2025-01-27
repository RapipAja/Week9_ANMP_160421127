package com.ubaya.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.todoapp.model.Todo
import com.ubaya.todoapp.model.TodoDatabase
import com.ubaya.todoapp.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.coroutines.CoroutineContext

class DetailTodoViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val todoLD = MutableLiveData<Todo>()
    private val job = Job()

    fun addTodo(todo: Todo) {
        launch {
            val db = buildDb(getApplication())
            db.todoDao().insertAll(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        launch {
            buildDb(getApplication()).todoDao().updateTodo(todo)
        }
    }

    fun update(title:String, notes:String, priority:Int, uuid:Int) {
        launch {
            val db = buildDb(getApplication())
            db.todoDao().update(title, notes, priority, uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun fetch(uuid: Int) {
        launch {
            val db = buildDb(getApplication())
            todoLD.postValue(db.todoDao().selectTodo(uuid))
        }
    }


}