package com.icure.cardinal.sdk.utils

import com.icure.cardinal.sdk.model.specializations.Base64String

fun ByteArray.base64Encode() = Base64String(com.icure.kryptom.utils.base64Encode(this))

fun Base64String.decode() = com.icure.kryptom.utils.base64Decode(this.s)