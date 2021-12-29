package com.jslee.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.jslee.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(binding.root)


        viewModel.adImages.observe(this, Observer {

            binding.imageView.load(it[0])
            binding.imageView2.load(it[1])
            binding.imageView3.load(it[3])
//            list?.let{
//            }
        })

//        viewModel.sales.observe(viewLifecycleOwner, Observer { list ->
//            list?.let {
//                adapter.replaceList(it)
//            }
//        })
    }

    override fun onDestroy() { // 액티비티가 파괴될 때..
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }


}