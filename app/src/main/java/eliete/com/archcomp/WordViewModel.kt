package eliete.com.archcomp

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

/**
 * Created by eliete on 2/25/18.
 */

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    internal val allWords: LiveData<ArrayList<Word>>

    init {
        repository = WordRepository(application)
        allWords = repository.getAllWords()
    }

    fun insert(word: Word) {
        repository.insertWord(word)
    }
}
