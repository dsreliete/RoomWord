package eliete.com.archcomp

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by eliete on 2/25/18.
 */
@Dao
interface WordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getWords(): LiveData<List<Word>>
    
}