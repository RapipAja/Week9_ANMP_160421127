package com.ubaya.todoapp.view

import android.view.View
import android.widget.CompoundButton
import com.ubaya.todoapp.model.Todo

interface TodoCheckedChangeListener {
    fun onCheckedChange(cb:CompoundButton, isChecked:Boolean, obj:Todo)
}
interface TodoEditClickListener {
    fun onTodoEditClick(v:View)
}