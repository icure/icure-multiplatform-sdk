// import 'dart:typed_data';
//
// abstract interface class KeyStorageFacade {
//
//   /// Returns the publicKey of the provided key from the storage.
//   /// [storageEntryKey]: the key of the value to retrieve.
//   /// Returns the publicKey associated to the provided [storageEntryKey] in spki format or null if no entry has such key.
//   /// Throws [IllegalEntityException] if there is a value stored at the provided entry key, but it is not a public key
//   Future<Uint8List?> getPublicKeySpki(String storageEntryKey);
//
//   /// Returns the privateKey of the provided key from the storage.
//   /// [storageEntryKey] the key of the value to retrieve.
//   /// Returns the privateKey associated to the provided [storageEntryKey] in pkcs8 format or null if no entry has such key.
//   /// Throws [IllegalEntityException] if there is a value stored at the provided entry key, but it is not a private key
//   Future<Uint8List?> getPrivateKeyPkcs8(String storageEntryKey);
//
//   /// Deletes the key associated to the provided storage entry key.
//   /// [storageEntryKey] the key of the value to delete.
//   Future<void> deleteKey(String storageEntryKey);
//
//   /// Stores the given public key under the given key in the storage. If an entry already exists for the given storage
//   /// key, it will be overwritten; if you want to store the keypair just store the private key instead (with
//   /// [storePrivateKey]), since the public key is derivable from the private key.
//   /// [storageEntryKey] the id of the entry in storage.
//   /// [publicKeySpki] the public key to store, in spki format.
//   Future<void> storePublicKey(String storageEntryKey,  publicKeySpki);
//
//   /// Stores the given public key under the given key in the storage. If an entry already exists for the given storage
//   /// key, it will be overwritten.
//   /// [storageEntryKey] the id of the entry in storage.
//   /// [privateKey] the private key to store, in pkcs8 format.
//   Future<void> storePrivateKey(String storageEntryKey, Uint8List privateKey);
// }