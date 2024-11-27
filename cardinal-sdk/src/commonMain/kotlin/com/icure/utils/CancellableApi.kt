package com.icure.utils


/**
 * This api method can be safely canceled, and should be canceled if you don't have interest in the result anymore.
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class CancellableApi()
