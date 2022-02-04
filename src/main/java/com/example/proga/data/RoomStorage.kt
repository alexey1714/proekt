package com.example.proga.data

import android.content.Context
import com.example.proga.data.room.AppDb
import com.example.proga.data.room.User
import com.example.proga.domain.SampleData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class RoomStorage(context : Context) : DataStorage {

    private val userDao = AppDb.getDatabase(context).userDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun save(sampleData: SampleData): Boolean {
        coroutineScope.launch {
            userDao.insert(User(name = sampleData.text))
        }
        return true
    }

    override fun get(): SampleData {
        val users = runBlocking {
            withContext(Dispatchers.Default) { userDao.getName() }
        }
        return SampleData(text = users.first().name.toString())
    }
}