package com.icure.sdk.storage

import com.icure.sdk.storage.impl.NativeFileStorageFacade
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import okio.FileSystem
import okio.Path.Companion.toPath

class NativeFileStorageTest : StringSpec({

	val storageDir = "scratch"

	"Can perform initialization and basic storage operations" {
		val storageFacade = NativeFileStorageFacade(storageDir)
		FileSystem.SYSTEM.exists(storageDir.toPath()) shouldBe true
		FileSystem.SYSTEM.exists("$storageDir/icure.store".toPath()) shouldBe true

		val key = "some-key"
		val value = "some-value"
		storageFacade.getItem(key) shouldBe null

		storageFacade.setItem(key, value)
		storageFacade.getItem(key) shouldBe value

		storageFacade.removeItem(key)
		storageFacade.getItem(key) shouldBe null
	}

	afterTest {
		FileSystem.SYSTEM.delete("$storageDir/icure.store".toPath())
		FileSystem.SYSTEM.delete(storageDir.toPath())
	}

})
