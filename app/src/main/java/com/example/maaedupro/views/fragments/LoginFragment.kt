package com.example.maaedupro.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.example.maaedupro.R
import com.example.maaedupro.utils.Constants
import com.example.maaedupro.utils.TextUtils
import com.example.maaedupro.utils.Utils
import com.example.maaedupro.viewmodel.LoginViewModel
import com.example.maaedupro.controllers.network.models.request.RequestOTP
import com.example.maaedupro.utils.Constants.RequestFragment.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.layout_btn_continue.*


class LoginFragment : BaseOrderFragment(), View.OnClickListener {

    var phone: String = ""
    var viewModel: LoginViewModel? = null

    //Companion object if single instance of fragment is to be maintained
    companion object {
        fun newInstance(args: Bundle?): LoginFragment {
            val fragment = LoginFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            btnContinue -> {
                if (checkInputValidations()) {
                    Utils.showKeyboard(activity, false)
                    val request = RequestOTP()
                    request.phone = phone.toLong()
                    viewModel?.requestOTP(request)?.observe(this,
                            Observer { it ->
                                var responseOTPResult = it?.result
                                Utils.showToast(activity, responseOTPResult?.message)
                                var bundle = Bundle()
                                bundle.putLong(Constants.RequestArgs.ARG_EXTRA_1, phone.toLong())
                                openFragment(FRAG_DASHBOARD, bundle, false)
                            })
                }
            }
        }
    }


    override fun extractData() {
        //Extract data from intent received
    }

    override fun initComponents() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        btnContinue.alpha = .5f

        et_contact_number.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                btnContinue.performClick()
                true
            } else false
        }

        et_contact_number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                if (editable.toString().length == 10) {
                    btnContinue.isClickable = true
                    btnContinue.alpha = 1f
                } else {
                    btnContinue.isClickable = false
                    btnContinue.alpha = .5f
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        //Initialize all the view components
        btnContinue.setText(R.string.btn_get_otp)
        btnContinue.setOnClickListener(this)
        et_contact_number.requestFocus()
        Handler().postDelayed({
            Utils.showKeyboard(activity, true)
        }, 500)
    }

    override fun inflateInitialViews(isVeryFirstRun: Boolean) {
        /************This method will be called every time fragment is shown on UI, *************
         *** boolean tells you whether fragment is attached for first time or from back stack *****/
    }

    private fun checkInputValidations(): Boolean {
        phone = et_contact_number.text.toString().trim()
        if (TextUtils.isEmpty(phone)) {
            Utils.showToast(activity, getString(R.string.error_phone_empty))
            return false
        }
        if (!Utils.isValidPhoneNumber(phone)) {
            Utils.showToast(activity, getString(R.string.error_phone_invalid))
            return false
        }
        return true
    }
}