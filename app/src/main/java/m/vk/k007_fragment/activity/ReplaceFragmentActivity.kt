package m.vk.k007_fragment.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_replace_fragment.*
import m.vk.k007_fragment.R
import m.vk.k007_fragment.fragment.OneFragment
import m.vk.k007_fragment.fragment.ThreeFragment
import m.vk.k007_fragment.fragment.TwoFragment
import java.text.SimpleDateFormat
import java.util.*

class ReplaceFragmentActivity : AppCompatActivity() {

    var TAG_OneFragment : String = "TagOneFragment"
    var TAG_TwoFragment : String = "TagTwoFragment"
    var TAG_ThreeFragment : String = "TagThreeFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_replace_fragment)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

        tvReplaceOneFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayoutReplace,
                OneFragment.newInstance("การแทนที่(Replace) Fragment",sdf.format(Date())),
                TAG_OneFragment)/*.addToBackStack(TAG_OneFragment)*/.commit()
        }

        tvReplaceTwoFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayoutReplace,
                TwoFragment.newInstance(),
                TAG_TwoFragment)/*.addToBackStack(TAG_TwoFragment)*/.commit()
        }

        tvReplaceThreeFragment.setOnClickListener {
            val randomInteger = (1..100).shuffled().first()
            supportFragmentManager.beginTransaction().replace(R.id.frameLayoutReplace,
                ThreeFragment.newInstance("การแทนที่(Replace) Fragment",sdf.format(Date()), randomInteger),
                TAG_ThreeFragment)/*.addToBackStack(TAG_ThreeFragment)*/.commit()
        }

        tvRemoveReplaceOneFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutReplace).toString().trim().equals(TAG_OneFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
        tvRemoveReplaceTwoFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutReplace).toString().trim().equals(TAG_TwoFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
        tvRemoveReplaceThreeFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutReplace).toString().trim().equals(TAG_ThreeFragment)){
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
        var f = fm.findFragmentById(R.id.frameLayoutReplace)
        if(f != null){
            return f
        }
        return null
    }
}
