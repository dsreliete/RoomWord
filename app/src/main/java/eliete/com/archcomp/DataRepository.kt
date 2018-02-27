package eliete.com.archcomp

import android.arch.lifecycle.LiveData

/**
 * Created by eliete on 2/26/18.
 */
interface DataRepository {

    fun getAllWords(): LiveData<List<Word>>

    fun insertWord(word: Word)

}