package eliete.com.archcomp

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by eliete on 2/26/18.
 */

class WordViewModelFactory(val wordRepository: DataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java))
            return WordViewModel(wordRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
