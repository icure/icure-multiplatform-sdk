package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.ServiceLink
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceLink_toJs(obj: ServiceLink): ServiceLinkJs {
	val serviceId = obj.serviceId ?: undefined
	return ServiceLinkJs(js("{" +
		"serviceId:serviceId" +
	"}"))
}

public fun serviceLink_fromJs(obj: ServiceLinkJs): ServiceLink {
	val serviceId = obj.serviceId
	return ServiceLink(
		serviceId = serviceId,
	)
}
