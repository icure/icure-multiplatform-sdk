package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade

/**
 * Returns a storage facade that stores the items as files in the provided directory.
 * Not all platform support this (js browser).
 * @throws UnsupportedOperationException if the current platform does not support file system storage.
 */
@Suppress("FunctionName")
expect suspend fun FileStorageFacade(directory: String): StorageFacade
