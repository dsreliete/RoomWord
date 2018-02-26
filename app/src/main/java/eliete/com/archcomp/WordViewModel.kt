package eliete.com.archcomp

import android.arch.lifecycle.ViewModel

/**
 * Created by eliete on 2/25/18.
 */

class WordViewModel(val repository: WordRepository) : ViewModel() {

    val allWords = repository.getAllWords()

    fun insert(word: Word) {
        repository.insertWord(word)
    }
}
