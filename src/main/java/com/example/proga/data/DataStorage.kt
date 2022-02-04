package com.example.proga.data

import com.example.proga.domain.SampleData

interface DataStorage  {

    fun save(sampleData: SampleData): Boolean

    fun get(): SampleData
}