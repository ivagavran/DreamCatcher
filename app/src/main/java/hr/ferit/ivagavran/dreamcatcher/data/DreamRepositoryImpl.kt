package hr.ferit.ivagavran.dreamcatcher.data

import hr.ferit.ivagavran.dreamcatcher.model.Dream

class DreamRepositoryImpl(val dreamDao: DreamDao) : DreamRepository {
    override fun save(dream: Dream) = dreamDao.save(dream)
    override fun delete(dream: Dream) = dreamDao.delete(dream)
    override fun getDreamById(id: Long): Dream? = dreamDao.getDreamById(id)
    override fun getAllDreams(): List<Dream> = dreamDao.getAllDreams()
}