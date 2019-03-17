package com.dogoodapps.data.di

import com.dogoodapps.data.framework.HtmlParser
import com.dogoodapps.data.framework.HtmlParserImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UtilsModule {

    @Singleton
    @Binds
    internal abstract fun bindsHtmlParser(htmlParserImpl: HtmlParserImpl): HtmlParser
}