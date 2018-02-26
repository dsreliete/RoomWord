package eliete.com.archcomp

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by eliete on 2/25/18.
 */
@Entity(tableName = "word_table")
data class Word(@PrimaryKey val word : String) {


}