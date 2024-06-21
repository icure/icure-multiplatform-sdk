package com.icure.sdk.test

import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.CryptoApiImpl
import com.icure.sdk.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
val CryptoApi.internal get() = (this as CryptoApiImpl).internal