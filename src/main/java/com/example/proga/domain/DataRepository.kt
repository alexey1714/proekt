package com.example.proga.domain

import com.example.proga.domain.SampleData

interface DataRepository {

    fun saveData(sampleData: SampleData): Boolean

    fun getData(): SampleData
}