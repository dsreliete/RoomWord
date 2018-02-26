package eliete.com.archcomp

import android.app.Application
import java.util.concurrent.ExecutorService

/**
 * Created by eliete on 2/26/18.
 */
class MyApplication : Application() {

    private lateinit var executor : ExecutorService
    private lateinit var dependencies: Dependencies

    override fun onCreate() {
        super.onCreate()

        dependencies = Dependencies(this)
    }

    fun getInicializacoes() = dependencies
}