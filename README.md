## Organization 

![Organization](readme-resources/organization.svg)

The core module contains the logic of the iCure sdk. Part of this logic, such as encryption, requires platform-specific 
implementations, using the platform sdks.

The core module can be used as-is from java or kotlin android apps, desktop java or kotlin apps or other 
kotlin/multiplatform apps. For every other platform we need to create wrappers.

### Swift wrapper

This is not mandatory since the compiled ios module is compatible with objective-c and it is possible to use objective-c
libraries from swift, but this wrapper allows to use the iCure sdk in a more natural way for swift developers.
For example this wrapper allows to use kotlin suspend functions as swift async functions, instead of normal functions 
with completion callbacks.

### Kotlin/js wrapper

This wrapper allows to use the iCure SDK from typescript or javascript. The compiled kotlin/js can run but is not 
callable from javascript/typescript. In order to allow the usage of kotlin functions from javascript we have to mark the 
members with `@JsExport`, but this is not allowed on members with some types or other characteristics. The wrapper
performs the necessary conversions and makes the exposed API callable from javascript.

### Dart and react native wrappers
These wrappers allow to use the iCure sdk from react native or dart. They connect the react/dart interfaces to the ios 
and android implementations.

## Notes

With multiple modules the yarn lock may have some issues...
https://youtrack.jetbrains.com/issue/KT-55701/KJS-Gradle-kotlinUpgradeYarnLock-and-kotlinStoreYarnLock-dont-support-configureondemand-if-building-one-module-only