package com.icure.utils

/**
 * Used to mark models and services (or part of them) which are kept `public` because they are needed in other modules,
 * but are not part of any public iCure API and should not be used by the end user.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPEALIAS, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR)
@RequiresOptIn(
	level = RequiresOptIn.Level.ERROR,
	message = "This API is meant to be used internally only by iCure. The signature and semantics of this API may change without notice."
)
annotation class InternalIcureApi