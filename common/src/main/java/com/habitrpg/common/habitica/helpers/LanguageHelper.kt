package com.habitrpg.common.habitica.helpers

import android.content.res.Resources
import android.os.Build
import java.util.Locale

class LanguageHelper(languageSharedPref: String?) {
    var locale: Locale
        private set
    var languageCode: String? = null
        private set

    init {
        when (val pref = languageSharedPref ?: "en") {
            "iw" -> {
                locale = Locale("iw")
                languageCode = "he"
            }
            "hr" -> {
                locale = Locale("hr", "HR")
                languageCode = "hr"
            }
            "in" -> {
                locale = Locale("in")
                languageCode = "id"
            }
            "pt" -> {
                locale = Locale("pt", "PT")
                languageCode = "pt"
            }
            else -> {
                locale =
                    if (pref.contains("_")) {
                        val languageCodeParts = pref.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        Locale(languageCodeParts[0], languageCodeParts[1])
                    } else {
                        Locale(pref)
                    }
                languageCode = languageSharedPref
            }
        }
    }

    companion object {
         // always returns the first entry in the system's locale list (the OS setting
        val systemLocale: Locale
            get() =
                Resources.getSystem().configuration.locales[0]
    }

}
