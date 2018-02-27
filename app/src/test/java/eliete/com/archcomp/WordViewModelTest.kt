package eliete.com.archcomp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import java.util.*

/**
 * Created by eliete on 2/26/18.
 */

class WordViewModelTest {

    @JvmField
    @Rule
    val testingRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

//    @Test
//    fun first_test() {
//
//        val dao = mockDao()
//        val repository = WordRepository(dao, Executor { r -> r.run() })
//        val viewModel = WordViewModel(repository)
//        val observer: Observer<List<Word>> = Mockito.mock(Observer::class.java) as Observer<List<Word>>
//
//        viewModel.allWords().observeForever(observer)
//
//        viewModel.insert(Word("a"))
//        Mockito.verify(observer).onChanged(Collections.singletonList(Word("a")))
//
//
//        viewModel.insert(Word("b"))
//        Mockito.verify(observer).onChanged(Arrays.asList(Word("a"), Word("b")))
//
//
//        viewModel.insert(Word("c"))
//        Mockito.verify(observer).onChanged(Arrays.asList(Word("a"), Word("b"), Word("c")))
//
//
//    }

    @Test
    fun read_test() {

        val list: MutableLiveData<List<Word>> = MutableLiveData()
        list.value = mutableListOf()

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getAllWords()).thenAnswer { list }
        }

        val viewModel = WordViewModel(repository)
        val observer: Observer<List<Word>> = Mockito.mock(Observer::class.java) as Observer<List<Word>>

        viewModel.allWords().observeForever(observer)

        viewModel.insert(Word("a"))
        Mockito.verify(observer).onChanged(Collections.singletonList(Word("a")))

        viewModel.insert(Word("b"))
        Mockito.verify(observer).onChanged(Arrays.asList(Word("a"), Word("b")))

        viewModel.insert(Word("c"))
        Mockito.verify(observer).onChanged(Arrays.asList(Word("a"), Word("b"), Word("c")))
    }

    @Test
    fun insert_test() {

        val word = Word("dgfdhgdhghd")

        val list: MutableLiveData<List<Word>> = MutableLiveData()
        list.value = mutableListOf()

        val repository = Mockito.mock(DataRepository::class.java).apply {
            Mockito.`when`(getAllWords()).thenAnswer { list }
        }

        val viewModel = WordViewModel(repository)
        val observer: Observer<List<Word>> = Mockito.mock(Observer::class.java) as Observer<List<Word>>

        viewModel.allWords().observeForever(observer)
        viewModel.insert(word)
        Mockito.verify(repository).insertWord(word)
        Mockito.verify(observer).onChanged(Collections.singletonList(word))

    }

//    private fun mockDao(): WordDAO {
//        val list: MutableLiveData<List<Word>> = MutableLiveData()
//        list.value = mutableListOf()
//        return Mockito.mock(WordDAO::class.java).apply {
//            Mockito.`when`(getWords()).thenReturn(list)
//            Mockito.`when`(insert(anyObject())).thenAnswer {
//                val word: Word = it.getArgument(0)
//                (list.value as MutableList).add(word)
//            }
//        }
//    }
//
//    private fun <T> anyObject(): T {
//        return Mockito.anyObject<T>()
//    }
}

