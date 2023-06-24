package oks.ro.application2.utils

import java.util.regex.Pattern

class UtilsFunctions {
    companion object {
        @JvmStatic
        fun isValidEmail(email: String): Boolean {
            val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
            val pattern = Pattern.compile(emailRegex)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }
    }
}