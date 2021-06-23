package com.amiir.baloot.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import timber.log.Timber

class KeyBoardHelper(var activity: Activity) {

    private fun closeKeyBoard() {
        var imm: InputMethodManager?
        try {
            imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    fun focusRequest(editText: AppCompatEditText) {
        try {
            editText.requestFocus()
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    fun focusRequest(editText: EditText) {
        try {
            editText.requestFocus()
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    fun hideKeyboardTouchOutSide(): OnFocusChangeListener {
        return OnFocusChangeListener { _, focus ->
            if (!focus) {
                closeKeyBoard()
            }
        }
    }
}