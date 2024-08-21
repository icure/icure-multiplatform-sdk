package com.icure.sdk.storage

import com.icure.sdk.storage.impl.FileStorageFacade
import com.icure.sdk.test.nextUuid
import com.icure.sdk.utils.IcurePlatform
import com.icure.sdk.utils.currentPlatform
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.random.Random

class FileStorageTest : StringSpec({
	val platformTestDirectoryBase: String? = when (currentPlatform) {
		IcurePlatform.Android -> null
		IcurePlatform.Ios -> null
		IcurePlatform.Browser -> null
		IcurePlatform.Node -> "/tmp"
		IcurePlatform.Jvm -> "/tmp"
		IcurePlatform.Mac -> "/tmp"
		IcurePlatform.Linux -> "/tmp"
		IcurePlatform.Windows -> null
	}

	"File storage should be able to create read and delete entries".config(
		enabledIf = { platformTestDirectoryBase != null }
	) {
		val subdir = Random.nextUuid()
		val storage = FileStorageFacade("$platformTestDirectoryBase/$subdir".also { println("Test directory: $it") })
		val item1 = Random.nextUuid()
		val item2 = Random.nextUuid()
		val data1 = Random.nextUuid()
		val data2 = Random.nextUuid()
		val data3 = Random.nextUuid()
		storage.setItem(item1, data1)
		storage.setItem(item2, data2)
		storage.getItem(item1) shouldBe data1
		storage.getItem(item2) shouldBe data2
		storage.setItem(item1, data3)
		storage.getItem(item1) shouldBe data3
		storage.removeItem(item2)
		storage.getItem(item2) shouldBe null
	}
})