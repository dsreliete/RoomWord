package eliete.com.archcomp

import android.arch.lifecycle.LiveData
import java.util.concurrent.Executor


/**
 * Created by eliete on 2/25/18.
 */

open class WordRepository internal constructor(val wordDao: WordDAO, val ioExecutor: Executor) : DataRepository {

    override fun getAllWords(): LiveData<List<Word>> {
        return wordDao.getWords()
    }

    override fun insertWord(word: Word) {
        ioExecutor.execute({
            wordDao.insert(word)
        })
    }
}
