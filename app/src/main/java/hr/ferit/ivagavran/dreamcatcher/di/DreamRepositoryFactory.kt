package hr.ferit.ivagavran.dreamcatcher.di

import hr.ferit.ivagavran.dreamcatcher.Dreamie
import hr.ferit.ivagavran.dreamcatcher.data.DreamRepository
import hr.ferit.ivagavran.dreamcatcher.data.DreamRepositoryImpl
import hr.ferit.ivagavran.dreamcatcher.data.room.DreamDatabase

object DreamRepositoryFactory {
    val roomDb = DreamDatabase.getDatabase(Dreamie.application)
    val dreamRepository: DreamRepository = DreamRepositoryImpl(roomDb.getDreamDao())
}