package eliete.com.archcomp

import android.arch.persistence.room.Room
import android.content.Context
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by eliete on 2/26/18.
 */

class Dependencies(val context : Context) {

    private val wordRepository : DataRepository by lazy {
        WordRepository(roomDatabase.wordDao(), IOExecutor)
    }

    private val roomDatabase : WordRoomDatabase by lazy {
        Room.databaseBuilder(context.applicationContext,
                WordRoomDatabase::class.java, "word_database")
                .build()
    }

    private val IOExecutor : ExecutorService by lazy {
        Executors.newSingleThreadExecutor()
    }

    val viewMoldelFactory : WordViewModelFactory by lazy {
        WordViewModelFactory(wordRepository)
    }
}