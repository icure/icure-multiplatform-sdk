# Multiplatform SDK design

## Encryptable entities design

All encryptable entities must extend the Encryptable interface. For each entity we have a sealed interface and two concrete data class implementations. The two concrete implementations are completely identical except in name.

![https://plantuml.github.io/plantuml-core/raw.html?bSj12e0W44RXlQVm8EAcEiWq_e4mckXi8hfxgvHerVOzlfWLTIE6NJBNeoYj0djUniH-fZqhiLhd6aWGlBSn5K52rlPnBDHwHHWuaDARFc-m6R_O3G00](https://www.plantuml.com/plantuml/svg/bSj12i9044JHVKun1maXe1wad2aXqDs6wSf2nBkxqYYktFxFcrFesjo69SH-GMKvHUstLJWRo_qnV9p3DOIgCev96DiqbSLNepEKFwuQybtPTjmWVDFNszcH_x6PqJQt9m00)

### Encryptable `type`

In addition to the properties defined in the backend the encryptable entity in the SDKs also has a `type` field. This is a value depends solely on the type of the entity and is used as a salt for some cryptographic operations. The only exception is the encryptable stubs, which have no corresponding type and instead use the type of the original entity they were stubbed from.

### `copy ` method

If we want to allow our end users to work directly with the encryptable entity interface it may be convenient to provide a copy method, like in data classes. This would be the case if we want to implement the "flexi" apis explained later.

In that case we have two options: 

1. Add a copy method to the interface and implement it on the data class. Disadvantage: the name of the method can't be `copy` (the code will not compile otherwise):

   ```kotlin
   sealed interface Foo {
   	val a: Int
   	val b: String
   
   	fun copyWith(a: Int = this.a, b: String = this.b): Foo
   }
   
   data class EncryptedFoo(
   	override val a: Int,
   	override val b: String
   ) : Foo {
   	override fun copyWith(a: Int, b: String): EncryptedFoo =
   		copy(a = a, b = b) // Or EncryptedFoo(a = a, b = b)
   }
   
   data class DecryptedFoo(
   	override val a: Int,
   	override val b: String
   ) : Foo {
   	override fun copyWith(a: Int, b: String): DecryptedFoo =
   		copy(a = a, b = b) // Or DecryptedFoo(a = a, b = b)
   }
   ```

2. Make a `copy` extension method on the interface that dispatches based on the instance of this. Disadvantage: the user will need to import the method if he wants it to be available on the interface.
   ```kotlin
   sealed interface Foo {
   	val a: Int
   	val b: String
   }
   
   fun Foo.copy(a: Int = this.a, b: String = this.b): Foo = when (this) {
   	is EncryptedFoo -> copy(a = a, b = b)
   	is DecryptedFoo -> copy(a = a, b = b)
   }
   
   data class EncryptedFoo(
   	override val a: Int,
   	override val b: String
   ) : Foo
   
   data class DecryptedFoo(
   	override val a: Int,
   	override val b: String
   ) : Foo
   ```

## Encryptable entities api design

For the each encryptable entity we have two apis:

- The internal "raw" api, that is fully generated and just corresponds 1-to-1 to the rest api. The raw Api only works with the encrypted variant of the entities.
- The user-facing api, which adds the cryptographic capabilities, performs various checks, and in general simplifies the usage of the api.

The user-facing api can be divided in 3 parts as well (flavours):

- Fully decrypted api: automatically decrypts the entity before returning and automatically encrypts it before saving it. The methods of this api will fail if the user can't decrypt the entity (the user can't access the encryption key of the entity)
- Fully encrypted api: returns the data without decrypting it, and can also be used to modify the fields of the entity that do not require encryption. If the user tries to use this api to modify some fields of the entity which should be encrypted the operation will fail.
- Flexible api (better names suggestions?): this api uses the interface of the encryptable entity, and not with the encrypted or decrypted variant. When retrieving data the api will try to decrypt it and if it can't it will just return the encrypted entity. When updating data the api will check if the input is decrypted or encrypted and dispatch accordingly.

Almost all methods of the encryptable entities api can be used in all flavours, including:

- Simple entity update methods (although the flavour may restrict what can be updated, depending on the encrypted fields configuration)
- Getting an entity, including with list/find methods 
- Sharing an entity (you can always share an entity you have access to; note: having an encrypted entity does not necessarily mean that the user does not have access to any encryption key, it could simply be a choice for efficiency)
- Attachment managment methods, since most of them return the updated document. Important note: in this case the flavour does not specify the encryption of the attachment but only of the returned document. This is because the encryption of attachments is not covered by the encryption manifest and there is no encrypted self in the attachment it is not obvious wheter a certain attachments needs to be encrypted and or decrypted. The attachment managements methods names must explicitly say if the attachment will be encrypted/decrypted by the method, so for each flavour we will have both get/set plain attachment and get/set encrypted attachment methods.

The methods that are not available in all flavours are:

- The newInstance and entity creation methods: when creating new data it must have valid encryption metadata initialized.
  - What if the secretary creates the patient? If she creates the patient she is the owner: she can share it with the doctor and revoke later. If the doctor puts an encrypted note then she will be able to read it... Add a patient template entity? Used just to allow the doctor to be the owner of the patient (the secretary pre-fills some information that the doctor uses to create the patient).
- For some entities there may be some update methods that require some context which can be obtained only from the decrypted entity
- Methods that do not use the entity in the signature, such as match / find ids of methods: since the entity is never given in input / never returned as output there is no reason to have multiple versions of these methods
- more?

### Design

We introduce a `CommonEntityApi<E>` interface which holds all methods which can exist in all 3 flavours. The `EntityApi` itself extends the `CommonEntityApi<DecryptedEntity>` but also has all the methods that are not available in all flavours. Additionally the `EntityApi` has 2 properties that give access to the flexible common api and encrypted common api; the result is that the api can be used for example in the following way:

```kotlin
val decryptedContact = icureApi.contact.getContact(contactId) // DecryptedContact
val encryptedContact = icureApi.contact.encrypted.getContact(contactId) // EncryptedContact
val maybeDecryptedContact = icureApi.contact.flexi.getContact(contactId) // Contact
```



![https://plantuml.github.io/plantuml-core/raw.html?bLJ1Rfj04Btp5NDCbE8FG1PIvBPI3fMgf4eklgpPmHaLPj7kEYvoykyTuwK65YhbOWFpTjwRzmQ8FTfI5GWRKzU6DuQzAlnzG-iDP11kSpWb07UmHn-Ut93EuCbRulsjmBfgRJILRGyeBlzIx00VIK83hfubD4OkRDjur5ciurjVwyLq9yeA_z0CUWGY9a-g8eV_cln0hxJowghlAuxxVu6A-3VgdyeJiW32nMqCxKWAYyfZDFOKEtTSJ1bOaHwQz3sFHf8OrkiTiSvpa53IFEgJ9udQEM_b4efAEGVtuJRgDKwLwgR2McPpCUivc5FVzWFqXVEco60QI5Y00JZ4UGQVqvyUaBalCgS5uNqGIN3g0T_FAIyLfpPS0J1SjaTr78ubdY_HhbPY_w9rKGpHOcxvMPPDjWkTME39jx33qbY4eoMFMtv4Vx3iG3aW-Ir58iZsw6Hkpa-gkOe8kjo87AW4HjIemLXu6-WCGmJ5M_vbIPvxqqS-rBba-IUrHWky8DfjEOWOkPKiCgrM-IJl35wiQXnOTPJ3paED_jLe1y821oSjIvcNTTKoEfU4rPgCDtfFHgiq0PeqNLhgEUYIdHay_EVDx2VOjH9HXNlvFF5-hltCLYLHSB5X0susd1OTVy_w5m00](https://www.plantuml.com/plantuml/svg/hLF1ZjCm4BtdA-R82h8V45NHhbgGze245WINNjnuKaOuuygUKgBk_Zics6nSDrpWqYQPvtdlpHlVUL5EZeEfY0LThpg4jHq6oslBeZgvFz1g3Gt4rnRE5S1hsAF4Bwz8D_1H7F7-9i2cwc0rzMC2TB__Gt42F5SPLsA9ZP4xDnu4TLFgU9jgISnqeZVuWwwWCn0n2Ib37lyqUO-Yj1Brec-3UVytO8Y_eVwWX90383xSbD29f7Ee12zj5zXhnyDGPgEeZuVwgIqiGGEhrOvOjos4KEgswDDMbTfvSU4HEgEyX_luMlJAKwNXO7105f-pfc3EgUqpw8ap-6lWCf0ftmoCdC0X_V90y3t9B0g1zo58WdC2lFkLyb9nWqkdORviZ-eqjnLclaHxU_lKbgDRZA5Op2r_LeQq4lI0B2GZxB2t3k7aI73BZoX7nnwK1mg_lQ03XqfNqUU_g7aH4NNvZ1oe1qRKgC4w-3xJ6Kr4nLl-v0WzY4sHptLkyBzCBc-pBDflEOh8fbKjCGKTxKNU3Nnnwk31gHCuz083obUhFGGME7fqq3j2rcPazBwAgvNRo-v9laeNG5lNIqjz3ReqpWOU_d8pauFT21eDxfKGxw-rBxQgK54EBETcotKtyIVMwWvP7mVp4m00)

### Simplify paginated methods

Paginated methods with nextKey/nextDocId are not very user friendly: they can add quite a bit of overhead when doing something like an "infinite scroll". It could be nice to provide simplified version returning a suspend version of iterable.

This, however, should probably be in addition to the standard methods with nextKey/nextDocId, since different users may have different requirements and a simplified method only could not be enough to cover all these cases.

For example if an application needs to display pages with a next and prev button they will need to keep a cache of past keys. We can provide a wrapper to allow for this, but there may be many more use cases and we can most definitely not cover them all...

### Basic apis for encryptable entities

In some cases the user of the SDK may not be a data owner, or may not want to use cryptography for other reasons. Currently in the typescript SDK we provide "BasicApis" to cover these use cases, and for encryptable entities we just provide access to the raw api, but this is not ideal: some method of the RawApi are not meant for the end-user and may need to be hidden or wrapped in some way.

This design at the previous chapter does not keep into consideration basic apis, so it will need some adjusting. The following table shows some categories of methods and in which types of apis they can be present:

| Method type                     | Flavourless | Flavoured | Basic api (!= raw api) | Where                |
| ------------------------------- | ----------- | --------- | ---------------------- | -------------------- |
| newInstance/create              | x           |           |                        | EApi                 |
| update                          |             | x         | x                      | EBasicFlavouredApi   |
| share                           |             | x         |                        | EFlavouredApi        |
| encrypted attachment management |             | x         |                        | EFlavouredApi        |
| plain attachment management     |             | x         | x                      | EBasicFlavouredApi   |
| Match / find ids / count        | x           |           | x                      | EBasicFlavourlessApi |

- Flavoured: it can be done with fully encrypted entities / fully decrpyted entities / flexi
- Flavourless: it does not make sense to divide the methods in 3 flavours: there are 2 options:
  - The method requires full decryption or encryption of unencrypted data (crate)
  - The method does not involve the entity (match or find ids or count)
- Basic api: methods that can be done without being a data owner (example: you are an admin but not an hcp)

![https://plantuml.github.io/plantuml-core/raw.html?bPBVJiCW5CRlUOfpkKNx0gGXSNLBJBpp2H1EDn9A2L1rKTzTRAckAIpP5V--y_q-3YWJqBLS83Iz2Lo47VTA73H_wmUdqVi7g-2J0Dn1nuCu9PNVdJUjqh6MpeM7SRcbyAnyg5-2K-R8o3SXwXe2PGJK3VpPi4GRhEG1q-P6J6DKHK2JTIqRgivgxD04NqoGeFx4NOOvJUv1eiPZJFKaAKmNdDEiu_oRjXe_5Ct7J1577HhXpZQWp6lty_6YI3ZCjUaHb-BjUkitzaNMQh3L5xlo2yhYHICfrFMhCf8nYAzGiHMNaKl6w2RxTrE05qpNpRZ5DDte1m00](https://www.plantuml.com/plantuml/svg/fP91JiCm44NtFiKi6q4k44LMQMWb97QSmDYJrfBZHFOOg82x4r876Zd9feieylZFVtz6tdeIZa9ZcBQ4hXOIeMej2KaxuRKy6F7M1cVG-uTEmoS3k8D6a3n5bT-TDxKsVMynDXw6OrR0i_PKlf3JziZPDrj7eEe1PGL_DZpIGgS4OInkvENVgxB-ctLTDjHDPx11ItunGOJwat0fCnRkGQ71eo1yKWLS1XpJf77-JMk37xgOZnaZ3ZgqqfqxGZMltO_NaoRfS6vDZpWLPsdfD_PLrZnq-HTVUGNBuiaY2oZBLsqLvr1MaFE4ozarOt1JxRjDuMkcUtkBwJWHsw9LeJ4_)

#### Difference between raw and basic api

The raw api is just the rest api without any additional stuff. Example: the `setMainAttachment` method on a document:

Raw:

```kotlin
// Ambiguous name: if you pass in input encrypted data the attachment will be encrypted, if you pass plain data the attachment will not be encrypted
suspend fun setMainAttachment(docId: String, docRev: String?, data: ByteArray): EncryptedDocument = // generated code
```

Basic or Flavourless:

```kotlin
// Different name: make it clear it is not going to do any encryption
suspend fun setPlainMainAttachment(doc: Document, plainData: ByteArray): EncryptedDocument =
  rawApi.setMainAttachment(doc.id, doc.rev, plainData)
```