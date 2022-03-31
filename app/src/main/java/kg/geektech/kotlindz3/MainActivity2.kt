package kg.geektech.kotlindz3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlindz3.databinding.ActivityMain2Binding

class MainActivity2 : BaseActivity<ActivityMain2Binding>() {

    private  lateinit var adapter: AdapterSecond
    private  var listImage = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initAdapter()
    }


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMain2Binding {
     return ActivityMain2Binding.inflate(inflater)
    }
    private fun initAdapter() {
        adapter = AdapterSecond()
        binding.rv.adapter= adapter
        adapter.setList(listImage)
    }

    override fun initView() {
        super.initView()
        binding.rv.layoutManager= GridLayoutManager(this, 3)
        listImage = intent.getIntegerArrayListExtra("list")!!

        }

    }
