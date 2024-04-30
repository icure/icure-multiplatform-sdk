## Using the project

You need to create a local properties file in the root of the project with the following properties:

```properties
# Path to the android sdk, by default on mac /Users/you/Library/Android/sdk
sdk.dir=/path/to/android/sdk
# Name of ios simulator to use for testing, e.g. iPhone 13 Pro Max
ios.simulator=iPhone name
```

## Testing

Unit tests can run on all target platforms (jvm, js browser, js node, ios, android) using the various gradle `[platform]Test` tasks, or using the `allTests` task.

E2e tests are currently only available on the jvm platform, as the test setup library is not yet available for the other platforms.

### Browser tests

Currently the project is configured to do browser tests on Chrome and Firefox. You will need to have the browsers installed on your machine.

You may also need to specify the location of their executables through environment variables, such as:

```
FIREFOX_BIN=/Applications/Firefox.app/Contents/MacOS/firefox
```

## Multiplatform sdk modules

### Kryptom - kotlin crypto multiplatform

This could be technically a separate project, but for now only what is needed for the iCure sdk is implemented.

Provides access from kotlin multiplatform to:
- Native cryptographic primitives and digest algorithms including:
  - Secure random
  - Aes encryption
  - Rsa encryption and signing
  - Hmac signing
- Byte array encoding and decoding (hex, base64)

## Notes

With multiple modules the yarn lock may have some issues...
https://youtrack.jetbrains.com/issue/KT-55701/KJS-Gradle-kotlinUpgradeYarnLock-and-kotlinStoreYarnLock-dont-support-configureondemand-if-building-one-module-only

## Js wrapper design

### Model

The model of the js wrapper consists of 3 parts:
- Typescript model definitions and implementations
- Kotlin references to the `external` js model
- Converters from the multiplatform model to the js model and vice versa

Doing the model implementation typescript and then referring to it from kotlin as external instead of using only kotlin
or only typescript has the following advantages:
- Better user-facing types: kotlin `Map<String, Something>` can be converted to `{ [key: string]: Something }` in 
  typescript. If we use `@JsExport` there is no way of specifying such type (we would get `any`).
- If we were to use only the typescript definition without a corresponding `external` kotlin reference we would need to 
  expose builders for the multiplatform module in order to allow the implementation of converters in typescript. This 
  would pollute the js module with definitions that are not aimed at the end-user. 

Typescript model implementation example:

```typescript
interface Address {
  street: string
  postboxNumber: string | null
  readonly isEncrypted: boolean
}

interface Patient {
  id: string
  addresses: Address[]
  readonly isEncrypted: boolean
}

class DecryptedAddress {
  constructor(partial: Partial<DecryptedAddress> = {}) {
    // noinspection PointlessBooleanExpressionJS - if we get partial from javascript there is no guarantee partial.isEncrypted is boolean
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) {
      throw new Error("partial.isEncrypted must be undefined or false")
    }
    this.street = (partial.street === undefined) ? "default street" : partial.street
    // Only undefined means use the default value. Null can override the default -> can't use ??
    this.postboxNumber = (partial.postboxNumber === undefined) ? "0" : partial.postboxNumber
  }
  readonly street: string
  readonly postboxNumber: string | null
  readonly isEncrypted: false = false
}

class DecryptedPatient implements Patient{
  constructor(partial: Partial<DecryptedPatient> = {}) {
    // noinspection PointlessBooleanExpressionJS - if we get partial from javascript there is no guarantee partial.isEncrypted is boolean
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) {
      throw new Error("partial.isEncrypted must be undefined or false")
    }
    this.id = (partial.id === undefined) ? "default-generate-new" : partial.id
    this.addresses = (partial.addresses === undefined) ? [] : partial.addresses
  }
  id: string
  addresses: DecryptedAddress[]
  readonly isEncrypted: false = false
}

function useModel() {
  // Gives error due to invalid address (missing members), can fix by wrapping in `new DecryptedAddress`
  // This way we can ensure that all default values in sub-objects are set properly
  new DecryptedPatient({
    id: "id",
    addresses: [{ street: "street" }]
  })


  const address = new DecryptedAddress({ street: "street" }) as Address
  new DecryptedPatient({ id: "id", addresses: [address] }) // Gives error: no guarantee that address is decrypted

  // Ok, everything is set to default
  new DecryptedPatient()

  // Default id, default street number in address
  new DecryptedPatient({
    addresses: [new DecryptedAddress({ street: "street" })]
  })

  // Also ok: everything is defined, but instanceof will not work...
  const x: DecryptedPatient = {
    id: "id",
    addresses: [new DecryptedAddress({ street: "street" })],
    isEncrypted: false
  }
}
```

Kotlin external model reference + converters implementation: 

```kotlin
external interface Address {
	val street: String
	val postboxNumber: String?
	val isEncrypted: Boolean
}

external interface Patient {
	val id: String
	val addresses: Array<out Address>
	val isEncrypted: Boolean
}

external class DecryptedAddress(partial: dynamic) : Address {
	override val street: String
	override val postboxNumber: String?
	override val isEncrypted: Boolean
}

external class DecryptedPatient(partial: dynamic) : Patient {
	override val id: String
	override val addresses: Array<DecryptedAddress>
	override val isEncrypted: Boolean
}

// Conversions overloads for decrypted and encrypted - better type checking
fun patientToJs(patient: com.icure.sdk.model.Patient): Patient =
	when (patient) {
		is com.icure.sdk.model.DecryptedPatient -> patientToJs(patient)
		is com.icure.sdk.model.EncryptedPatient -> TODO()
	}

fun patientToJs(patient: com.icure.sdk.model.DecryptedPatient): DecryptedPatient {
	val id = patient.id
	val addresses = CheckedConverters.listToArray(patient.addresses) { addressToJs(it) }
	return DecryptedPatient(js("({id: id, addresses: addresses})"))
}

fun addressToJs(address: com.icure.sdk.model.embed.Address): Address =
	when (address) {
		is com.icure.sdk.model.embed.DecryptedAddress -> addressToJs(address)
		is com.icure.sdk.model.embed.EncryptedAddress -> TODO()
	}
fun addressToJs(address: com.icure.sdk.model.embed.DecryptedAddress): DecryptedAddress {
	val street = address.street
	val apartmentNumber = address.postboxNumber
	return DecryptedAddress(js("({street: street, apartmentNumber: apartmentNumber})"))
}

fun patientToKt(patient: Patient): com.icure.sdk.model.Patient =
	if (patient.isEncrypted) {
		TODO()
	} else {
		patientToKt(patient as DecryptedPatient)
	}
fun patientToKt(patient: DecryptedPatient): com.icure.sdk.model.DecryptedPatient = com.icure.sdk.model.DecryptedPatient(
	id = patient.id,
	addresses = CheckedConverters.arrayToList(patient.addresses) { addressToKt(it) }
)

fun addressToKt(address: Address): com.icure.sdk.model.embed.Address =
	if (address.isEncrypted) {
		TODO()
	} else {
		addressToKt(address as DecryptedAddress)
	}
fun addressToKt(address: DecryptedAddress): com.icure.sdk.model.embed.DecryptedAddress =
	com.icure.sdk.model.embed.DecryptedAddress(
		street = address.street,
		postboxNumber = address.postboxNumber
	)
```

#### Converting types
multiplatform type -> external interface/class type -> typescript type

Primitives and standard library types:
- `String` -> `String` -> `string`
- `Int` | `Long` | `Double` | `Instant` -> `Double` -> `number` ; include range and int checks when converting, as needed
- `Boolean` -> `Boolean` -> `boolean`
- `Set<T>` -> `Array<T>` -> `T[]` ; include checks for duplicates
- `List<T>` -> `Array<T>` -> `T[]`
- `Map<K, V>` -> `dynamic` -> `{ [key: string]: V }` ; if K is not a string it needs to be convertible

To generate case by case:
- `enum class` -> `String` -> `string` ; include checks for valid values

### API

The purpose of the js api is just to convert the suspend functions to promises and to convert the input/output to the 
multiplatform/js model. The actual logic is delegated to the multiplatform api implementation.

The js api is implemented in kotlin/js and uses the `@JsExport` annotation to expose the functions to javascript.

```kotlin
@JsExport
@JsName("PatientApi")
class JsPatientApi private constructor(
	private val patientApi: com.icure.sdk.api.flavoured.PatientApi
) {
	fun modifyPatient(patient: DecryptedPatient): Promise<DecryptedPatient> = GlobalScope.promise {
		patientToJs(patientApi.modifyPatient(patientToKt(patient)))
	}
}
```

We may also want to add an index to simplify the import of the js api in the js code.