package com.example.maaedupro.views.activities
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.View
import com.example.maaedupro.R
import com.example.maaedupro.listeners.FragmentSelectionListener
import com.example.maaedupro.utils.Constants
import com.example.maaedupro.utils.Utils
import com.example.maaedupro.views.fragments.DashBoardFragment
import com.example.maaedupro.views.fragments.LoginFragment
import kotlinx.android.synthetic.main.layout_custom_toolbar.*

abstract class BaseFragmentActivity : BaseActivity() , FragmentSelectionListener,
    Constants.RequestAction, Constants.RequestArgs, Constants.RequestFragment,
    View.OnClickListener{

    private val TAG = BaseFragmentActivity::class.java.simpleName

    var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null

    var fragReqCode: Int = 0
    var fragReqData: Bundle? = null


    companion object {

        var isAppAlreadyRunning: Boolean = false
    }

    override fun navigateBack() {
        if (fragmentManager != null && fragmentManager!!.backStackEntryCount > 1)
            fragmentManager!!.popBackStack()
        else {
            finish()
            overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBaseComponents()
    }



    override fun onClick(p0: View?) {
        when (p0) {
            viewToolbarBack -> navigateBack()
            viewToolbarClose -> dismissCurrentFlow(true)

        }
    }


    private fun initBaseComponents() {

        fragmentManager = supportFragmentManager


    }


  //Fragments
    override fun onFragmentSelected(reqCode: Int, data: Bundle?) {
        //check if cec is selected or not
        Log.v("test123", "cec select condition add")
        onFragmentSelected(reqCode, data, true)
        Log.v("JsonDetails___________","Payment___"+ com.example.maaedupro.utils.JsonUtils.jsonify(reqCode));
    }

    override fun onFragmentSelected(reqCode: Int, data: Bundle?, addTobackStack: Boolean) {
        if (fragmentManager == null) return

        fragmentTransaction = fragmentManager!!.beginTransaction()
        if (fragmentManager!!.backStackEntryCount > 0) {
            fragmentTransaction!!.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left,
                R.anim.in_from_left, R.anim.out_to_right)
        }

        openFragment(reqCode, data, fragmentTransaction, addTobackStack)
    }

    fun getFragment(): Fragment? {
        if (fragmentManager != null)
            return fragmentManager!!.findFragmentById(R.id.fl_fragment_container)
        return null
    }

    private fun getFragment(reqCode: Int, data: Bundle?): Fragment? {
        when (reqCode) {
            /********************************** On-Boarding ******************************************/

            Constants.RequestFragment.FRAG_LOGIN -> return LoginFragment.newInstance(data)
            Constants.RequestFragment.FRAG_DASHBOARD -> return  DashBoardFragment.newInstance(data)



        }
        return null
    }

    private fun openFragment(reqCode: Int, data: Bundle?, fragmentTransaction: FragmentTransaction?,
                             addToBackStack: Boolean) {


        Log.v("JsonDetails___________","___openfrag"+reqCode.toString());
        if (fragmentTransaction == null) return
        Utils.showKeyboard(this, false)

        val fragment = getFragment(reqCode, data)
        if (fragment != null) {
            fragment.arguments = data
            fragmentTransaction.replace(R.id.fl_fragment_container, fragment, reqCode.toString())
            if (addToBackStack) fragmentTransaction.addToBackStack(reqCode.toString())
            fragmentTransaction.commitAllowingStateLoss() //commit();
        }
    }




    private fun dismissCurrentFlow(askForConfirmation: Boolean) {

        dismissCurrentFlow()
    }

    open fun dismissCurrentFlow() {
        Utils.showKeyboard(this, false)
        finish()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }

}