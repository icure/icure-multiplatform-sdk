package com.icure.cardinal.sdk.crypto.fake

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType

object NoDataOwnerApi : DataOwnerApi {
	override suspend fun getCurrentDataOwner(): DataOwnerWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerId(): String {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerReference(): DataOwnerReferenceInGroup {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerHierarchyIds(): List<String> {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerHierarchyIdsReference(): List<DataOwnerReferenceInGroup> {
		TODO("Not yet implemented")
	}

	override suspend fun getDataOwner(ownerId: String): DataOwnerWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCryptoActorStubInGroup(dataOwnerReferenceInGroup: DataOwnerReferenceInGroup): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): List<String> {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerHierarchy(): List<DataOwnerWithType> {
		TODO("Not yet implemented")
	}

	override suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerType(): DataOwnerType {
		TODO("Not yet implemented")
	}

	override fun clearCurrentDataOwnerIdsCache() {
		TODO("Not yet implemented")
	}
}