package com.morrine.hometrix.repository

import com.morrine.hometrix.data.MessageDao
import com.morrine.hometrix.model.Message
import kotlinx.coroutines.flow.Flow

class ChatRepository(private val messageDao: MessageDao) {
    fun getAllMessages(): Flow<List<Message>> = messageDao.getAllMessages()
    suspend fun insertMessage(message: Message) = messageDao.insertMessage(message)
    suspend fun clearMessages() = messageDao.clearMessages() // Added for completeness
}
