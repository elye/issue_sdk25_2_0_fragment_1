package framentissue25_2_0.myproject.com.fragmentissue1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, FragmentEmpty()).commit()
    }

    fun openFragmentThree() {
        supportFragmentManager.beginTransaction().replace(R.id.container, FragmentThree()).addToBackStack("").commit()
    }
}
