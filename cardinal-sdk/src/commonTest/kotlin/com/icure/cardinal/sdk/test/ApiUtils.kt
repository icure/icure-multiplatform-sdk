package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.impl.CryptoApiImpl
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
val CryptoApi.internal get() = (this as CryptoApiImpl).internal