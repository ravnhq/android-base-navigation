package com.example.ravn_navigation.nav

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyboardUtil {

    private var imm: InputMethodManager? = null

    fun hideKeyboard(activity: Activity) {
        val token = activity.findViewById<View>(android.R.id.content).windowToken
        getInputMethodManager(activity).hideSoftInputFromWindow(token, 0)
    }

    fun showKeyboard(activity: Activity) {
        getInputMethodManager(activity).showSoftInput(activity.currentFocus, InputMethodManager.SHOW_IMPLICIT)
    }

    fun findActivity(view: View): Activity? {
        var context: Context? = view.context
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }

    private fun getInputMethodManager(activity: Activity): InputMethodManager {
        return imm ?: (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).also {
            imm = it
        }
    }
}
