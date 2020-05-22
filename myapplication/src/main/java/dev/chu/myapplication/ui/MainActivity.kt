package dev.chu.myapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import dev.chu.myapplication.databinding.ActivityMainBinding
import dev.chu.myapplication.util.SingleLiveEvent
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    private lateinit var binding: Lazy<ActivityMainBinding>

    @Inject
    @Named("errorEvent")
    private lateinit var errorEvent: SingleLiveEvent<Throwable>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 이 액티비티를 lifecycleOwner로 설정하여, 생명 주기에 안전하게 데이터 바인딩을 할 수 있도록 한다.
        binding.get().lifecycleOwner = this

        errorEvent.observe(this, Observer {
            showErrorToast(it)
        })
    }

    private fun showErrorToast(throwable: Throwable) {
        throwable.printStackTrace()
        showToast(throwable.message)
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
