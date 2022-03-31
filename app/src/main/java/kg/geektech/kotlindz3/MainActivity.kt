package kg.geektech.kotlindz3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlindz3.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private  var listImage = arrayListOf<Int>()
    private  lateinit var adapter: Adapter
    private val listImageForNextActivity = arrayListOf<Int>()


    private fun initAdapter() {
        adapter = Adapter(this::onItemAdd, this::onItemDelete)
        binding.rv.adapter= adapter
        adapter.setList(listImage)
    }

    override fun initView() {
        super.initView()
        binding.rv.layoutManager= GridLayoutManager(this, 3)
        repeat(6){
            listImage.add(R.drawable.im1)
            listImage.add(R.drawable.im2)
            listImage.add(R.drawable.im3)
        }
    }
    private  fun onItemAdd(element: Int) {
        listImageForNextActivity.add(element)

    }
    private  fun onItemDelete(element: Int) {
        listImageForNextActivity.remove(element)
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initAdapter()
    }

    override fun initListener() {
        super.initListener()
        binding.btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("list", listImageForNextActivity)
            startActivity(intent)

        }
    }
    }

