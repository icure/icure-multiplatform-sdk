package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade

expect class ApplicationContext

@Suppress("FunctionName")
expect suspend fun ApplicationStorageFacade(context: ApplicationContext? = null): StorageFacade
