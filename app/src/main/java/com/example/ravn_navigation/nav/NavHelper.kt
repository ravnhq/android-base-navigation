package com.example.ravn_navigation.nav

import java.util.WeakHashMap
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NavHelper @Inject constructor() {

    private val deepLinkData: WeakHashMap<String, Any> = WeakHashMap()

    fun <T> setData(key: String, data: T) {
        deepLinkData[key] = data
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getData(key: String) = deepLinkData[key] as? T

    companion object {
        const val DATA_ID = "dataId"
        const val DEEPLINK_SCHEME = "ravNav://"
    }
}
