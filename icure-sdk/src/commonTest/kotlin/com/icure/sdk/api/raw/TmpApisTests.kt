package com.icure.sdk.api.raw

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.sdk.api.IcureApi
import com.icure.sdk.api.extended.AnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.Contact
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.Patient
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

@OptIn(InternalIcureApi::class)
class TmpApisTests : StringSpec({
	"Tmp api test" {
		val storage = VolatileStorageFacade()
		val key = "308204bf020100300d06092a864886f70d0101010500048204a9308204a50201000282010100c1c7537e17ed2db414ca0095a46aaee32066363f9e097087fb9e28d79830d490eceb3094dca1ef30fd20d8a6c783c6662258b4d9789f3f9d3908dc27dbca1499dbba201f6d0bbd95331026afdded957cde27c409581ab70eed133f6dd718f2c01c2d07b2d7b231cf6a73d74ea28beface6a75ea837225c416005dafa18f12ed769fee3cde3537cb04dec21232625f03d56c4b590ebd8c775e9a3fab73c29ff4d2792a2a776f11af01b0c51f2e2dc9e40d1ef080a4fa6d9c2ded124df03d49df19867b5ffefbc12e47db1102a0b7151daefce2e10eb41c72ce808cb7a564848a603e704f9ab673a6c08dc3f862e4abced2986364f157686f435d1cd6bc4ea13030203010001028201004f8a570e3a1a04199832f69c7619c861b889dc18aef126fcda5ea85b1ec064707c9f6998a11be347d38f68fec484a5aa84ccaea759a8dc7ed7cb783af02ff9d6d1e78b89fac3c7f4f739d8f7757c3151490b3f9faa4784fe9e77b920881b58815ccf6b0a911936f2f1ba4d159d091dbf760a1b83a6e5f6c26afcdc4eae70498e30fdee8a8931288b559518ebfeab00bfb10059ab77c804742968837e11e3ccfc2a23f67c41fc5d0c8f881b3c05de24e622db00bfa35c62db47326ad8dd125305b5d7b19291671d8ff33cd4b0cf68b35f80542792679abb462a6b9edbb058499f057fda16d3a1d6ebbd2922bb1bf35b5a4d2f3d709a68e872aa42a6c82ce6b3c102818100f3d424233e66a632a2dd2accc8d365037d107334996dc72244b6ad9738c070a58fd12ba0d9e99517139aba8a46356cfca94d3213e90f440be5b9b2869ab3a278a24859da23b3cceeb9186348b5fe2646a2e9f9a21eed1539c2877fa4b969a27e9102503db915161234807aa7511e16d71996d90b7ad54fe4aaaaf0ba47d02de302818100cb7399da839ee92846cca0d9d3e0a0fe2a844cc11627d9fbca56c33f0ae727d22fd85fd9f2d526ffb046e2594f01e52e1f0281c3d94613336b0b26ad905f615abf8ad09db68c1f7c157f46dbcb57e86b9a06610a4db6d441de6de6325431822904923db2677fc96a9b2a8f96075647afdecbfc6adc49b1bff86ce2173b3390610281810099badf2df961eed76e27d39c59e22e860c8c1a96c745978fdb92f1cfae5066b57bff7d6a64fa08ae0c063a26842d9b11920cc1ce1bdb2c23f42b288c056dccba12575b8f55833f6a23f9645fab9f19b2df747597e9b7c0f231dc0c7667105b0b41921bd54ea424ce459bdbb93243ae52e02763a101490c9e379c9f3a539cc5d102818100b151a4b3556a07ee499e8946b0aaa3c6420a22d75ad70adeafe064b52a6c834166dfdfd296197eaef4d522ec11b72626c77228e52816321feb58c1b21e1573456391b9f6eb263f3ea781d1a1391df9fce6364f176ada412ed38cd747e02772390bb9e5b9fb08dde4632e7a0c998272626efd3c976a3d74854b20a300fa611ba102818100ac02f2b5e4efcd7f64a77c17dd416d0d08c2a405faa339f7502f2ce900c223f6e4e146e4f39dfcbd61c45333320f6a97781b94e13b24797edf4a23a6b6a9de52eb7c3d8e03752f6e2c01e959dc80358344af9a573de60fd278e0a9bc279afa7a7eff80c2c7e3a8a5161b4a8a4601dad7da04ee7c34ba1e72c635b8b0927c60ae"
		val icureFacade = IcureStorageFacade(
			JsonAndBase64KeyStorage(storage),
			storage,
			DefaultStorageEntryKeysFactory,
			defaultCryptoService,
			false
		)
		icureFacade.saveEncryptionKeypair(
			"9d60b1ce-03b2-4331-aa4a-642ba1b56f7e",
			defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, hexToByteArray(key)),
			true
		)
		val api = IcureApi.initialise(
			"https://api.icure.cloud",
			UsernamePassword(username, password),
			storage
		)
		val patient = api.patient.encryptAndCreate(
			api.patient.initialiseEncryptionMetadata(
				Patient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = "Yeet"
				)
			)
		).shouldNotBeNull()
		val retrievedPatient = api.patient.getAndDecrypt(patient.id).shouldNotBeNull()
		val createdContact = api.contact.encryptAndCreate(
			api.contact.initialiseEncryptionMetadata(
				Contact(
					id = defaultCryptoService.strongRandom.randomUUID(),
					descr = "ASCASDFASDASDQWEQW",
				),
				retrievedPatient
			)
		).shouldNotBeNull()
		val retrievedContact = api.contact.getAndDecrypt(createdContact.id).shouldNotBeNull()
		println(retrievedContact)
		println(createdContact)
		println(retrievedPatient)
		println(patient)
	}
})