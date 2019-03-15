package m.vk.k007_fragment.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import m.vk.k007_fragment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAddFragment.setOnClickListener {
            var goAdd = Intent(this@MainActivity, AddFragmentActivity::class.java)
            startActivity(goAdd)
        }

        tvReplaceFragment.setOnClickListener {
            var goAdd = Intent(this@MainActivity, ReplaceFragmentActivity::class.java)
            startActivity(goAdd)
        }

        tvAttachDetachFragment.setOnClickListener {
            var goAdd = Intent(this@MainActivity, AttachDetachFragmentActivity::class.java)
            startActivity(goAdd)

        }
    }
}
