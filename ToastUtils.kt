fun View.showToast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this.context, resourceId, length).show()
}

fun View.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this.context, message, length).show()
}
