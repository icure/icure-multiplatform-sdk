import {
	CardinalKeyStorageOptions,
	CardinalStorageOptions,
	InternalCardinalKeyStorageOptionsFactory,
	InternalCardinalStorageOptionsFactory
} from "../cardinal-sdk-ts.mjs";

/**
 * Provides permanent storage capabilities to the SDK
 */
export interface StorageFacade {
	/**
	 * Returns the value of the provided key from the storage
	 * @param key Key of the value to retrieve
	 * @return The value associated to the provided key or null if there is no value stored at the provided key.
	 */
	getItem(key: string): Promise<string | undefined>

	/**
	 * Set an item in the storage for the given key. If an item already exists for the given key, it will be overwritten.
	 * @param key Key of the value to set
	 * @param value the value to store
	 */
	setItem(key: string, value: string): Promise<void>

	/**
	 * Removes the item with the given key from the storage, if present.
	 * Does nothing if there is no value.
	 * @param key The key of the item to remove.
	 */
	removeItem(key: string): Promise<void>
}

export namespace StorageFacade {
	/**
	 * Factory method returning storage options that will cause the sdk to store the data as files at the provided
	 * directory. These options are usable only on node.
	 * @param directory
	 */
	export function usingFileSystem(directory: string): CardinalStorageOptions {
		return InternalCardinalStorageOptionsFactory.getInstance().fileSystem(directory)
	}
	/**
	 * Factory method returning storage options that will cause the sdk to store the data as entries on the browser
	 * local storage. These options require the `localStorage` global to be available
	 */
	export function usingBrowserLocalStorage(): CardinalStorageOptions {
		return InternalCardinalStorageOptionsFactory.getInstance().browserLocalStorage()
	}
}

export interface KeyStorageFacade {
	/**
	 * Returns the publicKey of the provided key from the storage
	 * @param storageEntryKey Key of the value to retrieve
	 * @return The publicKey associated to the provided storageEntryKey in spki format or null if no entry has such key.
	 * @throws IllegalEntityException if there is a value stored at the provided entry key, but it is not a public key
	 */
	getPublicKeySpki(storageEntryKey: string): Promise<Int8Array | undefined>

	/**
	 * Returns the privateKey of the provided key from the storage
	 * @param storageEntryKey Key of the value to retrieve
	 * @return The privateKey associated to the provided storageEntryKey in pkcs8 format or null if no entry has such key.
	 * @throws IllegalEntityException if there is a value stored at the provided entry key, but it is not a private key
	 */
	getPrivateKeyPkcs8(storageEntryKey: string): Promise<Int8Array | undefined>

	/**
	 * Delete the key associated to the provided storage entry key
	 * @param storageEntryKey Key of the value to delete
	 */
	deleteKey(storageEntryKey: string): Promise<void>

	/**
	 * Stores the given public key under the given key in the storage. If an entry already exists for the given storage
	 * key, it will be overwritten; if you want to store the keypair just store the private key instead (with
	 * [storePrivateKey]), since the public key is derivable from the private key.
	 * @param storageEntryKey The id of the entry in storage
	 * @param publicKeySpki the public key to store, in spki format
	 */
	storePublicKey(storageEntryKey: string, publicKeySpki: Int8Array): Promise<void>

	/**
	 * Stores the given public key under the given key in the storage. If an entry already exists for the given storage
	 * key, it will be overwritten.
	 * @param storageEntryKey The id of the entry in storage
	 * @param privateKey the private key to store, in pkcs8 format
	 */
	storePrivateKey(storageEntryKey: string, privateKey: Int8Array): Promise<void>
}

export namespace KeyStorageFacade {
	/**
	 * Factory method returning storage options that will cause the sdk to store the keys as string entries on the
	 * provided storage facade. The raw keys data (spki or pkcs8) will be encoded as base 64
	 */
	export function encodingAsBase64(baseStorage: StorageFacade | CardinalStorageOptions): CardinalKeyStorageOptions {
		return InternalCardinalKeyStorageOptionsFactory.getInstance().encodingAsBase64(baseStorage)
	}

	/**
	 * Factory method returning storage options that will cause the sdk to store the keys as string entries on the
	 * provided storage facade. The keys will be stored as json in jwk format.
	 */
	export function encodingAsJwk(baseStorage: StorageFacade | CardinalStorageOptions): CardinalKeyStorageOptions {
		return InternalCardinalKeyStorageOptionsFactory.getInstance().encodingAsJwk(baseStorage)
	}
}