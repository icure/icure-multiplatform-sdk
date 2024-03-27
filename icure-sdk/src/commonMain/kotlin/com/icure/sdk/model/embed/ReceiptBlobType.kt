package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class ReceiptBlobType() {
    @SerialName("xades")
    Xades,

    @SerialName("kmehrRequest")
    KmehrRequest,

    @SerialName("kmehrResponse")
    KmehrResponse,

    @SerialName("soapRequest")
    SoapRequest,

    @SerialName("soapResponse")
    SoapResponse,

    @SerialName("soapConversation")
    SoapConversation,

    @SerialName("tack")
    Tack,
}
