package com.icure.sdk.storage.impl

import com.icure.sdk.storage.StorageFacade

/**
 * Returns a storage facade that stores the items as files in the provided directory.
 * Not all platform support this (js browser).
 * @throws UnsupportedOperationException if the current platform does not support file system storage.
 */
@Suppress("FunctionName")
expect fun FileStorageFacade(directory: String): StorageFacade
