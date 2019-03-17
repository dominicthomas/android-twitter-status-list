package com.dogoodapps.data.framework

import android.os.Build
import android.text.Html
import javax.inject.Inject

class HtmlParserImpl @Inject constructor() : HtmlParser {

    override fun parse(htmlString: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(htmlString, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(htmlString).toString()
        }
    }
}