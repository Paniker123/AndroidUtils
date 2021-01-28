/**
 * Hides software keyboard if visible
 * @param activity - target Activity
 */
fun hideSoftKeyboard(activity: Activity) {
    activity.currentFocus?.let {
        val manager = activity
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

/**
 * Closes keyboard on touch outside any EditText in passed root view
 * @param view rootView, that contains all visible views
 */
@SuppressLint("ClickableViewAccessibility")
fun hideKeyboardOnTouchOutside(view: View) {
    if (view !is EditText) {
        view.setOnTouchListener { v, _ ->
            hideSoftKeyboard(v)
            false
        }
    }
    if (view is ViewGroup) {
        for (i in 0 until view.childCount) {
            val innerView = view.getChildAt(i)
            hideKeyboardOnTouchOutside(innerView)
        }
    }
}

/**
 * Hides software keyboard if visible.
 * @param view - any view in corresponding View's tree.
 */
fun hideSoftKeyboard(view: View) {
    val manager = view.context
        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(view.windowToken, 0)
    view.clearFocus()
}
