package com.dogoodapps.chirp.presentation.ui.di

import android.content.Context
import com.dogoodapps.chirp.presentation.ui.framework.ImageLoader
import com.dogoodapps.chirp.presentation.ui.framework.PicassoWrapper
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
class ImageLoaderModule {

    @Singleton
    @Provides
    internal fun providePicasso(context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()
    }

    @Singleton
    @Provides
    internal fun provideOkHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

    @Singleton
    @Provides
    internal fun provideImageLoader(picasso: Picasso): ImageLoader {
        return PicassoWrapper(picasso)
    }
}