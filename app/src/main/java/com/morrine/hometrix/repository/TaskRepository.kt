package com.morrine.hometrix.repository

import com.morrine.hometrix.data.TaskDao
import com.morrine.hometrix.model.Task

class TaskRepository(private val taskDao: TaskDao) {
    val allTask = taskDao.getAllTask()

    suspend fun insert(task: Task) = taskDao.insertTask(task)
    suspend fun update(task: Task) = taskDao.updateTask(task)
    suspend fun delete(task: Task) = taskDao.deleteTask(task)
    suspend fun getById(id: Int) = taskDao.getTaskById(id)
}