package eliete.com.archcomp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel

/**
 * Created by eliete on 2/25/18.
 */

class WordViewModel(val repository: DataRepository) : ViewModel() {

    private val words: MutableLiveData<List<Word>> = MutableLiveData()

    init {
        repository.getAllWords().observeForever(object : Observer<List<Word>> {
            override fun onChanged(t: List<Word>?) {
                words.postValue(t)
                repository.getAllWords().removeObserver(this)
            }
        })
    }

    fun insert(word: Word) {
        words.postValue(words.value?.plus(word))
        repository.insertWord(word)
    }

    fun allWords(): LiveData<List<Word>> {
        return words
    }


}
