package eliete.com.archcomp

import android.arch.lifecycle.LiveData
import java.util.concurrent.ExecutorService


/**
 * Created by eliete on 2/25/18.
 */

class WordRepository internal constructor(val db: WordRoomDatabase, val ioExecutor: ExecutorService) {
    private val wordDao = db.wordDao()
    private val words: LiveData<List<Word>>

    init {
        words = wordDao.getWords()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return words
    }

    fun insertWord(word: Word) {
        ioExecutor.execute({
            db.runInTransaction {
                wordDao.insert(word)
            }
        })
    }
}
