package m.vk.k007_fragment.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_attach_detach_fragment.*
import m.vk.k007_fragment.R
import m.vk.k007_fragment.fragment.OneFragment
import m.vk.k007_fragment.fragment.ThreeFragment
import m.vk.k007_fragment.fragment.TwoFragment
import m.vk.k007_fragment.utiles.Utile
import java.text.SimpleDateFormat
import java.util.*

class AttachDetachFragmentActivity : AppCompatActivity() {

    var TAG_OneFragment : String = "TagOneFragment"
    var TAG_TwoFragment : String = "TagTwoFragment"
    var TAG_ThreeFragment : String = "TagThreeFragment"
    val  sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attach_detach_fragment)

        onAddFragmentToFirst()

        tvAttDeOneFragment.setOnClickListener {
            if (!(onCheckFragmentIsShow(R.id.frameLayoutAttDe).toString().trim().equals(TAG_OneFragment))){
                var fAttach = supportFragmentManager.findFragmentByTag(TAG_OneFragment)
                if (fAttach != null) {
                    var args = Bundle()
                    args.putString(Utile.ARG_PARAM1,"แนบเข้า(Attach) หรือ ถอนออก(Detach) Fragment")
                    args.putString(Utile.ARG_PARAM2,sdf.format(Date()))
                    fAttach.arguments = args

                    var fDetach = onFragmentIsShow()
                    var fm = supportFragmentManager.beginTransaction()
                    fm.attach(fAttach)
                    if (fDetach != null){//หากไม่มี Fragment ใดๆ แสดงอยู่ ไม่ต้องรับออก
                        fm.detach(fDetach)
                    }
                    fm.commit()

                }else{
                    var oneFragment = OneFragment.newInstance("แนบเข้า(Attach) หรือ ถอนออก(Detach) Fragment",sdf.format(Date()))
                    var fDetach = onFragmentIsShow()

                    var fm = supportFragmentManager.beginTransaction()
                    fm.add(R.id.frameLayoutAttDe,oneFragment,TAG_OneFragment)
                    if (fDetach != null){
                        fm.detach(fDetach)
                    }
                    fm.commit()
                }
            }

        }

        tvAttDeTwoFragment.setOnClickListener {
            if (!(onCheckFragmentIsShow(R.id.frameLayoutAttDe).toString().trim().equals(TAG_TwoFragment))){
                var fAttach = supportFragmentManager.findFragmentByTag(TAG_TwoFragment)
                if (fAttach != null) {

                    var fDetach = onFragmentIsShow()
                    var fm = supportFragmentManager.beginTransaction()
                    fm.attach(fAttach)
                    if (fDetach != null){//หากไม่มี Fragment ใดๆ แสดงอยู่ ไม่ต้องรับออก
                        fm.detach(fDetach)
                    }
                    fm.commit()

                }else{
                    var twoFragment = TwoFragment.newInstance()
                    var fDetach = onFragmentIsShow()

                    var fm = supportFragmentManager.beginTransaction()
                    fm.add(R.id.frameLayoutAttDe,twoFragment,TAG_TwoFragment)
                    if (fDetach != null){
                        fm.detach(fDetach)
                    }
                    fm.commit()
                }
            }
        }

        tvAttDeThreeFragment.setOnClickListener {
            if (!(onCheckFragmentIsShow(R.id.frameLayoutAttDe).toString().trim().equals(TAG_ThreeFragment))){
                var fAttach = supportFragmentManager.findFragmentByTag(TAG_ThreeFragment)
                if (fAttach != null) {
                    var args = Bundle()
                    args.putString(Utile.ARG_PARAM1,"แนบเข้า(Attach) หรือ ถอนออก(Detach) Fragment")
                    args.putString(Utile.ARG_PARAM2,sdf.format(Date()))
                    args.putInt(Utile.ARG_PARAM3,(1..100).shuffled().first())
                    fAttach.arguments = args

                    var fDetach = onFragmentIsShow()
                    var fm = supportFragmentManager.beginTransaction()
                        fm.attach(fAttach)
                        if (fDetach != null){//หากไม่มี Fragment ใดๆ แสดงอยู่ ไม่ต้องรับออก
                            fm.detach(fDetach)
                        }
                        fm.commit()
                }else{
                    var threeFragment = ThreeFragment.newInstance("แนบเข้า(Attach) หรือ ถอนออก(Detach) Fragment",sdf.format(Date()),(1..100).shuffled().first())
                    var fDetach = onFragmentIsShow()

                    var fm = supportFragmentManager.beginTransaction()
                    fm.add(R.id.frameLayoutAttDe,threeFragment,TAG_ThreeFragment)
                    if (fDetach != null){
                        fm.detach(fDetach)
                    }
                    fm.commit()
                }
            }
        }



        tvRemoveAttDeOneFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutAttDe).toString().trim().equals(TAG_OneFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
        tvRemoveAttDeTwoFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutAttDe).toString().trim().equals(TAG_TwoFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
        tvRemoveAttDeThreeFragment.setOnClickListener {
            if (onCheckFragmentIsShow(R.id.frameLayoutAttDe).toString().trim().equals(TAG_ThreeFragment)){
                supportFragmentManager.beginTransaction().remove(onFragmentIsShow()!!).commit()
            }
        }
    }

    fun onAddFragmentToFirst(){
        var threeFragment = ThreeFragment.newInstance("แนบเข้า(Attach) หรือ ถอนออก(Detach) Fragment",sdf.format(Date()),(1..100).shuffled().first())
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayoutAttDe,threeFragment,TAG_ThreeFragment)
            .detach(threeFragment)
            .commit()

        var twoFragment = TwoFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayoutAttDe,twoFragment,TAG_TwoFragment)
            .detach(twoFragment)
            .commit()

        var oneFragment = OneFragment.newInstance("แนบเข้า(Attach) หรือ ถอนออก(Detach) Fragment",sdf.format(Date()))
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayoutAttDe,oneFragment,TAG_OneFragment)
            //.detach(oneFragment)
            .commit()
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
        var f = fm.findFragmentById(R.id.frameLayoutAttDe)
        if(f != null){
            return f
        }
        return null
    }
}
