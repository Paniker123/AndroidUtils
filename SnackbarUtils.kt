
fun View.showSnackBar(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(this, message, duration).show()
}

fun View.showSnackBar(
    @StringRes messageResId: Int,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(this, messageResId, duration).show()
}

fun View.showSnackBarWithAction(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    actionId: String,
    action: View.OnClickListener
) {
    Snackbar.make(this, message, duration)
        .setAction(actionId, action)
        .show()
}

fun View.showSnackBarWithAction(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    @StringRes actionId: Int,
    action: View.OnClickListener
) {
    Snackbar.make(this, message, duration)
        .setAction(actionId, action)
        .show()
}

fun View.showSnackBarWithAction(
    @StringRes messageResId: Int,
    duration: Int = Snackbar.LENGTH_LONG,
    @StringRes actionId: Int,
    action: View.OnClickListener
) {
    Snackbar.make(this, messageResId, duration)
        .setAction(actionId, action)
        .show()
}
