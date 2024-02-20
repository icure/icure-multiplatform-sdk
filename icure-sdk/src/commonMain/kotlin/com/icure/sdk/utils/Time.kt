package com.icure.sdk.utils

/**
 * Get the epoch timestamp in milliseconds (since midnight, January 1, 1970 UTC).
 * Note that in some systems this value is not guaranteed to be monotonic (for example if you call this function just
 * before and just after the system clock was synchronised on ios you may get a lower value the second time), therefore
 * it should not be used for operations where this property is critical.
 */
expect fun currentEpochMs(): Long
