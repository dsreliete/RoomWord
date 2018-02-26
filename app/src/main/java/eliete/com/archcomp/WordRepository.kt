package eliete.com.archcomp

import android.app.Application
import android.arch.lifecycle.LiveData



/**
 * Created by eliete on 2/25/18.
 */

class WordRepository internal constructor(application: Application) {
    private var db : WordRoomDatabase? = null
    private val wordDao: WordDAO
    private val words: LiveData<ArrayList<Word>>

    init {
        db = WordRoomDatabase.getDatabase(application)
        wordDao = db!!.wordDao()
        words = wordDao.getWords()
    }

    fun getAllWords(): LiveData<ArrayList<Word>> {
        return words
    }

    fun insertWord(word: Word) {
        db!!.runInTransaction {
            wordDao.insert(word)
        }
    }
}
