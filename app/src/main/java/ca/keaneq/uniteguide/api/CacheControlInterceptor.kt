package ca.keaneq.uniteguide.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

private const val MAX_AGE = 60 * 60 * 24 // read from cache for 1 day
private const val MAX_STALE = 60 * 60 * 24 * 7 // tolerate 1 week stale
private const val HEADER_KEY_CACHE_CONTROL = "Cache-Control"
private const val CACHE_CONTROL_HAS_NETWORK = "public, max-age=$MAX_AGE"
private const val CACHE_CONTROL_HAS_NO_NETWORK = "public, only-if-cached, max-stale=$MAX_STALE"

class CacheControlInterceptor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val cacheControl = if (context.hasNetwork()) {
            CACHE_CONTROL_HAS_NETWORK
        } else {
            CACHE_CONTROL_HAS_NO_NETWORK
        }

        val request = chain
            .request()
            .newBuilder()
            .header(HEADER_KEY_CACHE_CONTROL, cacheControl)
            .build()

        return chain.proceed(request)
    }
}