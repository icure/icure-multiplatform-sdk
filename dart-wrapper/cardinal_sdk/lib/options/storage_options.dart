class StorageOptions {
  /// Pre-made storage strategy which implementations depends on the native
  /// platform:
  /// - on Android, it uses Androidx DataStore.
  /// - on iOS, iPadOS, macOS & watchOS, it uses NSUserDefaults.
  /// - Browser is currently not supported for the Dart Cardinal SDk.
  static final StorageOptions PlatformDefault =
    StorageOptions._internal({"type": "com.icure.cardinal.sdk.dart.StorageFacadeOptions.Default"});

  final Map<String, dynamic> _json;
  StorageOptions._internal(this._json);

  static Map<String, dynamic> encode(StorageOptions value) {
    return Map.unmodifiable(value._json);
  }
}

/// Custom storage is currently not supported in Cardinal SDK
abstract class CustomStorageFacade {
  /// Stores string data using a custom implementation.
  String? getItem(String key);

  /// Get a stored entry or None if no entry is stored at the provided key
  String? setItem(String key, String value);

  /// Remove the entry at key
  String? removeItem(String key);
}