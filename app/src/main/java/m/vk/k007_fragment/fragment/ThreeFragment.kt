package m.vk.k007_fragment.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_three.*
import m.vk.k007_fragment.R
import m.vk.k007_fragment.utiles.Utile


class ThreeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: Int? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String,param3 : Int) =
            ThreeFragment().apply {
                arguments = Bundle().apply {
                    putString(Utile.ARG_PARAM1, param1)
                    putString(Utile.ARG_PARAM2, param2)
                    putInt(Utile.ARG_PARAM3,param3)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(Utile.ARG_PARAM1)
            param2 = it.getString(Utile.ARG_PARAM2)
            param3 = it.getInt(Utile.ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvShowThreeFragment.text = (param1 + "\n"+ param2 +"\n"+ param3)
    }
}
