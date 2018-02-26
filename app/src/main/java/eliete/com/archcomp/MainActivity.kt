package eliete.com.archcomp

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1

    private var mWordViewModel: WordViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(this, NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
        val adapter = WordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        mWordViewModel!!.allWords.observe(this, Observer {
            words -> adapter.setWords(words)
        })
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY))
            mWordViewModel!!.insert(word)
        } else {
            Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show()
        }
    }

    //https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#13
    //https://developer.android.com/topic/libraries/architecture/guide.html#recommended_app_architecture
}
