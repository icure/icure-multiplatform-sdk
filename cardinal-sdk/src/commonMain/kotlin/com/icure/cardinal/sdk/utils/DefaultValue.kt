package com.icure.cardinal.sdk.utils

/**
 * Supports code generation by providing access to the default value of a property.
 */
// TODO move to com.icure.cardinal.sdk.utils.generation
@Retention(AnnotationRetention.SOURCE)
internal annotation class DefaultValue(val value: String)
