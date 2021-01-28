/**
 * @param regex to check correct input
 * */
fun getFilters(regex: Regex): Array<InputFilter?> {
    val filters = arrayOfNulls<InputFilter>(1)
    filters[0] = InputFilter { source, start, end, dest, dstart, dend ->

        var keepOriginal = true
        val stringBuilder = StringBuilder(end - start)
        for (i in start until end) {
            val c = source[i]
            if (c.toString().matches(regex)) // setup your checking condition
                stringBuilder.append(c) else keepOriginal = false
        }

        if (keepOriginal) {
            return@InputFilter null
        }

        if (source is Spanned) {
            val spannableString = SpannableString(stringBuilder)
            TextUtils.copySpansFrom(source, start, spannableString.length, null, spannableString, 0)
            spannableString
        } else {
            stringBuilder
        }
    }

    return filters
}
