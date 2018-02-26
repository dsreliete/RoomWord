package eliete.com.archcomp

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by eliete on 2/25/18.
 */

@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDAO

    companion object {
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                WordRoomDatabase::class.java, "word_database")
                                .addCallback(sRoomDatabaseCallback)
                                .build()
                    }
                }
            }
            return INSTANCE
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                populaDB()
            }

            private fun populaDB() {
                INSTANCE!!.runInTransaction({
                    INSTANCE!!.wordDao().insertAll(WordGenerator().generateList())
                })
            }
        }
    }
}
