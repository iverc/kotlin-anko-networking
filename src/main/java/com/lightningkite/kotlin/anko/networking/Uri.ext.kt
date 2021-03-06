package com.lightningkite.kotlin.anko.networking

import android.content.ContentResolver
import android.net.Uri
import com.lightningkite.kotlin.stream.toByteArray
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by jivie on 6/2/16.
 */

fun Uri.toRequestBody(resolver: ContentResolver): RequestBody {
    val type = resolver.getType(this) ?: pathSegments.lastOrNull()?.split('.')?.lastOrNull() ?: throw IllegalArgumentException()
    return okhttp3.RequestBody.create(MediaType.parse(type), resolver.openInputStream(this).toByteArray())
}