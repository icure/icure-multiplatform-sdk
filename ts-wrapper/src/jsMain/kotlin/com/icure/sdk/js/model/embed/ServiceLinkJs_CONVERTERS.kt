// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.ServiceLink
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceLink_toJs(obj: ServiceLink): ServiceLinkJs {
	val serviceId = nullToUndefined(
		obj.serviceId
	)
	return ServiceLinkJs(js("{" +
		"serviceId:serviceId" +
	"}"))
}

public fun serviceLink_fromJs(obj: ServiceLinkJs): ServiceLink {
	val serviceId = undefinedToNull(obj.serviceId)
	return ServiceLink(
		serviceId = serviceId,
	)
}
