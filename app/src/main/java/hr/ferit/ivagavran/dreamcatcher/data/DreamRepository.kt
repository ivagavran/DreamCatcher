package hr.ferit.ivagavran.dreamcatcher.data

import hr.ferit.ivagavran.dreamcatcher.model.Dream

interface DreamRepository {
    fun save(dream: Dream)
    fun delete(dream: Dream)
    fun getDreamById(id: Long): Dream?
    fun getAllDreams(): List<Dream>
}