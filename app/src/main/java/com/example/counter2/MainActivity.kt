package com.example.counter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.counter2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )
        binding.viewModel = viewModel

        //이 액티비티의 라이프사이클에 맞춰 동작하겠다.. 이게 필요함
        //이 코드가 없으면 xml에 라이브데이터가 있어도 적용안된다.
        binding.lifecycleOwner = this //새로고침을 해주는 코드
        //라이브데이터 쓰면서 화면 돌려도 데이터가 그대로임.

//        //livedata쓰면서 필요없어짐..
//        //이값이 변할때마다 ui를 변경하겠다.
//        viewModel.countLiveData.observe(this, Observer { count ->
//            counter_text.text = "$count"
//        })

        //xml에 람다식으로 직접 적음 라이브데이터에 함수가 정의되어있기떄문에
//        add_button.setOnClickListener{
//            viewModel.increaseCount()
//        }
//        sub_button.setOnClickListener{
//            viewModel.decreaseCount()
//        }

    }


    //이런식으로 하면 앱이 강제종료당해도 중요한 데이터 저장가능능
//   override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("count", viewModel.count)
//
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        viewModel.count = savedInstanceState.getInt("count")
//
//    }



}