package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi


/**
 * Result of a decryption operation.
 *
 * @param I type of the input data
 * @param O type of the output data
 * @property failedDecryptions input data that failed to decrypt
 * @property successfulDecryptions output data that was successfully decrypted
 */
@InternalIcureApi
data class DecryptionResult<I, O>(
	val failedDecryptions: List<I>,
	val successfulDecryptions: List<O>,
)
