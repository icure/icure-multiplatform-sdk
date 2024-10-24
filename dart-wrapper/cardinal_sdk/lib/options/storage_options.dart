abstract class CustomStorageFacade {
  /// Stores string data using a custom implementation.
  String? getItem(String key);

  /// Get a stored entry or None if no entry is stored at the provided key
  String? setItem(String key, String value);

  /// Remove the entry at key
  String? removeItem(String key);
}