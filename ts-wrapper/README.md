# Why is this needed

The kotlin code works in js but it can't be called directly... Only declarations annotated with `@JsExport` are usable
directly from js, but there are limits to what can be exported, for example we can't export `suspend` functions or 
entities with public properties of type `List`, `Long` or other incompatible data types.

This wrapper provides a version of the SDK that uses only Js compatible declarations and automatically handles the 
conversions from the various kotlin models to javascript models.

Since the conversion between pure kotlin data types and functions to js exportable ones can be done following a set of
simple rules the ts-wrapper is for the most part automatically generated by the `sdk-codegen` module.

# Design

The wrapper is composed of both kotlin and typescript sources, which are accessible from kotlin through `external`
declarations. Technically we could have implemented a working wrapper using only kotlin sources, but having a mix of
both allows us to have more control over the final output, allowing for an sdk that is more natural for typescript 
users.

Both kinds of sources are compiled and then merged into a single package ready for publishing through the gradle task
`prepareDistributionPackage`

## Model

The model of the js wrapper consists of 3 parts:
- Typescript model definitions and implementations of the various classes constructors.
- Kotlin references to the `external` js model
- Converters from the multiplatform model to the js model and vice versa

Typescript model implementation example:

```typescript
interface Address {
   street: string
   postboxNumber: string | undefined
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
      this.street = ('street' in partial && partial.street !== undefined) ? partial.street : "default street"
      // If the postboxNumber is not in the partial then we are using the default (which in this case is "0").
      // If the partial explicitly sets { "postboxNumber": undefined } we are going to set it to undefined.
      this.postboxNumber = ('postboxNumber' in partial && partial.postboxNumber !== undefined) ? partial.postboxNumber : "0"
   }
   readonly street: string
   readonly postboxNumber: string | undefined
   readonly isEncrypted: false = false
}

class DecryptedPatient implements Patient{
   constructor(partial: Partial<DecryptedPatient> = {}) {
      // noinspection PointlessBooleanExpressionJS - if we get partial from javascript there is no guarantee partial.isEncrypted is boolean
      if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) {
         throw new Error("partial.isEncrypted must be undefined or false")
      }
      this.id = ('id' in partial && partial.id !== undefined) ? partial.id : "default-generate-new"
      this.addresses = ('addresses' in partial && partial.addresses !== undefined) ? partial.addresses : []
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
	val postboxNumber = address.postboxNumber ?: undefined
	return DecryptedAddress(js("({street: street, postboxNumber: postboxNumber})"))
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

### Mandatory constructor parameters

Normally in the constructor of model class `T` we take in input a `Partial<T>`, which allows user to specify the value
for some properties and take the default values for the rest.

There are however some model classes that have mandatory fields without a default. In these cases instead of simply
taking the partial as input to the constructor we take `Partial<T> & Pick<T, "mandatoryField1" | "mandatoryField2" | "...">`

The only exception is the `id` field: even though it is mandatory in kotlin, to simplify the usage of the typescript
wrapper we automatically generate an id for the entity if it is not given in input to the constructor.

### Simple type conversions
multiplatform type -> external interface/class type -> typescript type

Primitives and standard library types:
- `String` -> `String` -> `string`
- `Int` | `Long` | `Double` | `Instant` -> `Double` -> `number` ; include range and int checks when converting, as needed
- `Boolean` -> `Boolean` -> `boolean`
- `Set<T>` -> `Array<T>` -> `T[]` ; include checks for duplicates
- `List<T>` -> `Array<T>` -> `T[]`
- `Map<K, V>` -> `dynamic` -> `{ [key: string]: V }` ; if K is not a string it needs to be convertible
- `ZonedDateTime` -> `String` -> `string` ; convert using the json serializers
- `JsonElement` -> `dynamic` -> `any`

To generate case by case:
- `enum class` -> `String` -> `string` ; include checks for valid values

### Interface converters

When converting interfaces from javascript to kotlin we need to use a discriminator.

For encryptable entities the discriminator is the `isEncrypted` field. For other entities the discriminator is the 
`$ktClass` field, which contains the fully qualified name of the kotlin class.

Note that not all interfaces need converters: we need to build a converter for the interface only if it is used as an
input to an api function or if it is used as a field of a model class. This means that we need to add the discriminator
only to the classes where an interface converter is needed.

### Nested types
In typescript we can implement nested types using namespaces. For example if we had a declaration like this in kotlin:

```kotlin
data class SomethingDto(
	val a: String
) {
	data class Nested1Dto(
		val b: Int
	) {
		data class DeeplyNestedDto(
			val c: Boolean
		)
	}
	data class Nested2Dto(
		val d: String
	)
}
```

we could achieve a similar structure in typescript like this:

```typescript
export interface Something {
  a: string
}
export namespace Something {
  export interface Nested1 {
    b: number
  }
  export namespace Nested1 {
    export interface DeeplyNested {
      c: boolean
    }
  }
  export interface Nested2 {
    d: string
  }
}

// Usage
const deeplyNested: Something.Nested.DeeplyNested = { c: true }
```

To represent these external declarations in kotlin we need to ues the `@JsModule` annotation, which unfortunately can be
applied only to a whole file, and not only to a single declaration. The resulting files would look like this:

src/com/icure/sdk/model/js/Something.kt
```kotlin
package com.icure.cardinal.sdk.model.js

@JsName("Something")
external interface SomethingJs {
    val a: String
}
```
src/com/icure/sdk/model/js/Something_Nested.kt
```kotlin
@file:JsModule("Something")
package com.icure.cardinal.sdk.model.js

@JsName("Nested1")
external interface Something_Nested1Js {
    val b: Int
}

@JsName("Nested2")
external interface Something_Nested2Js {
    val d: String
}
```
src/com/icure/sdk/model/js/Something_Nested1_Nested.kt
```kotlin
@file:JsModule("Something.Nested1")
package com.icure.cardinal.sdk.model.js

@JsName("DeeplyNested")
external interface Something_Nested1_DeeplyNestedJs {
    val c: Boolean
}
```

### Sealed interfaces

We can implement sealed interfaces in typescript in the following way.

```typescript
type SealedInterface = ImplementationA | ImplementationB
namespace SealedInterface {
  export enum Type {
    ImplementationA = "com.icure.sdk.model.ImplementationA",
    ImplementationB = "com.icure.sdk.model.ImplementationB",
  }
}

class ImplementationA {
  $ktClass: SealedInterface.Type.ImplementationA = SealedInterface.Type.ImplementationA
  propertyOfInterface: string
  propertyOfOnlyA: string

  constructor(propertyOfInterface: string, propertyOfOnlyA: string) {
    this.propertyOfInterface = propertyOfInterface
    this.propertyOfOnlyA = propertyOfOnlyA
  }
}

class ImplementationB {
  $ktClass: SealedInterface.Type.ImplementationB = SealedInterface.Type.ImplementationB
  propertyOfInterface: string
  propertyOfOnlyB: string

  constructor(propertyOfInterface: string, propertyOfOnlyB: string) {
    this.propertyOfInterface = propertyOfInterface
    this.propertyOfOnlyB = propertyOfOnlyB
  }
}

function useSealed(sealed: SealedInterface) {
  console.log(sealed.propertyOfInterface) // Part of the intersection, usable without any (smart) cast
  const x = sealed.$ktClass // This is a SealedInterface.Type
  if (sealed instanceof ImplementationA) { // More natural but only works if the class was created with new
    console.log(sealed.propertyOfOnlyA) // Ok, smart cast
  } else {
    console.log(sealed.propertyOfOnlyB) // Ok, smart cast
  }
  if (sealed.$ktClass === SealedInterface.Type.ImplementationA) { // A bit weird, but works even if class was not initialized with new
    console.log(sealed.propertyOfOnlyA) // Ok, smart cast
  } else {
    console.log(sealed.propertyOfOnlyB) // Ok, smart cast
  }
}

useSealed({ $ktClass: SealedInterface.Type.ImplementationA, propertyOfInterface: "fake without new - will not pass instanceof -> prints undefined next (tries to get propertyOfOnlyB)", propertyOfOnlyA: "fakeA" })
useSealed(new ImplementationA("real with new", "realA"))
```

## API

The purpose of the js api is just to convert the suspend functions to promises and to convert the input/output to the
multiplatform/js model. The actual logic is delegated to the multiplatform api implementation.

For the apis we have:
- A typescript interface
- The corresponding external declaration in kotlin
- An internal implementation of the interface in kotlin, which delegates to the multiplatform api implementation

```kotlin
@JsName("PatientApi")
external interface PatientApiJs {
	fun modifyPatient(patient: DecryptedPatient): Promise<DecryptedPatient>
}

internal class PatientApiImplJs(
	private val patientApi: com.icure.sdk.api.PatientApi
): PatientApiJs {
	override fun modifyPatient(patient: DecryptedPatient): Promise<DecryptedPatient> = GlobalScope.promise {
		patientToJs(patientApi.modifyPatient(patientToKt(patient)))
	}
}
```

## Manually implemented components

Some declarations are manually implemented since they are too special and there is no reason to equip the generator with
components dedicated just to generate a single class.

These declarations include utility functions used by the generated code (e.g. for the conversion of primitive types), and
some model classes that also have some logic embedded in them.

# Building the package

There is a `prepareDistributionPackage` task that compiles the kotlin and typescript sources and combines them in a 
single package. 

The steps performed are the following:

1. Compilation of the kotlin sources
2. Generation of typescript "index" files, to provide easy access to all packages of the typescript sources
3. Compilation of the typescript sources and index files. This step requires a reference to the compiled kotlin sources.
4. Patching of the compiled javascript. This includes:
   - Adding imports of the declarations from the typescript sources
   - Adding exports of the declarations from the typescript sources in the package entry point
   - Patch ktor

## Patching of ktor

Currently the implementation of ktor uses `require` in some parts, which does not work when using ES modules 
([issue](https://youtrack.jetbrains.com/issue/KTOR-6158/JS-ReferenceError-require-is-not-defined-when-compiling-to-ES-Module)).

It seemed like we had 2 options: either build our own engine that does not use the require or simply patch the usages of require
in the compiled javascript.

However when using websockets part of the implementation uses the require also outside of the engine 
([here](https://github.com/ktorio/ktor/blob/1eeb7c11c93ad1cce550c71df1a189d22c74148f/ktor-utils/jsAndWasmShared/src/io/ktor/util/CryptoJs.kt#L44)
which means that patching is the only real option.

The patch we apply uses a static import and refer to that import instead of using an inline `require`. We could not use 
the dynamic import since that returns a promise of the module and would need more effort to be used. This means that the
modules will be loaded even if we are running on browser, but they will never be used in that case. For this reason it
may be a good idea to ignore those modules when using tools like webpack, for example by applying the following config:

```javascript
module.exports = {
    mode: 'production',
    resolve: {
        modules: [
            "node_modules"
        ],
        alias: {
            // Configuration to ignore modules
            "crypto": false,
            "ws": false,
            "abort-controller": false,
            "node-fetch": false,
        }
    },
    plugins: [],
    module: {
        rules: []
    },
    entry: {
        main: ["./sample.mjs"]
    },
    output: {
        filename: "bundle.js",
        libraryTarget: "module",
        globalObject: "this"
    },
    experiments: {
        outputModule: true
    }
};
```

# Usage with expo

The icure-multiplatform sdk (and more specifically ktor) uses some things that are not available on expo, such as the
streaming body on fetch.

To use the ts-wrapper of the iCure multiplatform sdk on expo you need to add some polyfills. More information on this
at https://github.com/icure/icure-api-expo-support
