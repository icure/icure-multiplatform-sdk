package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specifies a behaviour for the sharing of encryption keys or owning entity ids in the extended apis 'share' methods.
 */
@Serializable
enum class ShareMetadataBehaviour {
	/**
	 * The method must share the metadata with the delegate. If this is not possible, because for example the current user has no access to this kind of
	 * metadata, the method will throw an error.
	 */
	@SerialName("REQUIRED")
	Required,
	/**
	 * The method must share the metadata with the delegate if available. If this is not possible, because for example the current user has no access to
	 * this kind of metadata, the method will simply not share this metadata.
	 */
	@SerialName("IF_AVAILABLE")
	IfAvailable,
	/**
	 * The method must not share the metadata with the delegate, even if the current data owner can access it.
	 */
	@SerialName("NEVER")
	Never
}
