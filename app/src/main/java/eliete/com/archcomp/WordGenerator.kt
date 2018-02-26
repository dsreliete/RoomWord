package eliete.com.archcomp

/**
 * Created by eliete on 2/25/18.
 */

class WordGenerator(){
    private var list : MutableList<Word> = ArrayList()

    fun generateList() : List<Word> {
        list.add(Word("fdfds"))
        list.add(Word("fdfds"))
        list.add(Word("fdfds"))
        list.add(Word("fdfds"))
        list.add(Word("fdfds"))
        return list
    }
}
