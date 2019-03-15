package m.vk.k007_fragment.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_add_fragment.*
import m.vk.k007_fragment.R
import m.vk.k007_fragment.fragment.OneFragment
import m.vk.k007_fragment.fragment.ThreeFragment
import m.vk.k007_fragment.fragment.TwoFragment
import java.text.SimpleDateFormat
import java.util.*

class AddFragmentActivity : AppCompatActivity() {

    var TAG_OneFragment : String = "TagOneFragment"
    var TAG_TwoFragment : String = "TagTwoFragment"
    var TAG_ThreeFragment : String = "TagThreeFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fragment)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

        tvAddOneFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.frameLayoutAdd,
                OneFragment.newInstance("การเพิ่ม(Add) Fragment",sdf.format(Date())),
                TAG_OneFragment)/*.addToBackStack(TAG_OneFragment)*/.commit()
        }

        tvAddTwoFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.frameLayoutAdd,
                TwoFragment.newInstance(),
                TAG_TwoFragment)/*.addToBackStack(TAG_TwoFragment)*/.commit()
        }

        tvAddThreeFragment.setOnClickListener {
            val randomInteger = (1..100).shuffled().first()
            supportFragmentManager.beginTransaction().add(R.id.frameLayoutAdd,
                ThreeFragment.newInstance("การเพิ่ม(Add) Fragment",sdf.format(Date()),randomInteger),
                TAG_ThreeFragment)/*.addToBackStack(TAG_ThreeFragment)*/.commit()
        }

        tvRemoveAddOneFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutAdd).toString().trim().equals(TAG_OneFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
        tvRemoveAddTwoFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutAdd).toString().trim().equals(TAG_TwoFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
        tvRemoveAddThreeFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutAdd).toString().trim().equals(TAG_ThreeFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
    }

    fun onCheckFragmentIsShow(idFragment : Int): String {
        var strTag : String = ""
        var fm = supportFragmentManager
        var f = fm.findFragmentById(idFragment)
        if(f != null){
            strTag = f.tag!!
        }
        return strTag
    }
    fun onFragmentIsShow(): Fragment? {
        var fm = supportFragmentManager
        var f = fm.findFragmentById(R.id.frameLayoutAdd)
        if(f != null){
            return f
        }
        return null
    }
}
