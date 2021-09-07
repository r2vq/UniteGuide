package ca.keaneq.uniteguide.api

import android.content.Context
import android.net.ConnectivityManager

/**
 * Quick check if there is network available.
 *
 * @return `false` if there is no network or if Connectivity Manager is not found. True otherwise.
 */
fun Context.hasNetwork(): Boolean =
    (getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)
        ?.activeNetworkInfo
        ?.isConnected
        ?: false