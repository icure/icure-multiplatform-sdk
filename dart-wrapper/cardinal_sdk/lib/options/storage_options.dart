sealed class StorageOptions {

  static Map<String, dynamic> encode(StorageOptions value) {
    switch(value) {
      case FileSystemStorage storage:
        return {
          'type': 'com.icure.cardinal.sdk.py.PyStorage.StorageFacadeOptions.File',
          'directory': storage.directory
        };
      case CustomStorageFacade _:
        return {
          "type": "com.icure.cardinal.sdk.py.PyStorage.StorageFacadeOptions.Custom"
        };
    }
  }
}

class FileSystemStorage implements StorageOptions {
  /**
   * Store data as files at the provided directory
   */
  final String directory;

  FileSystemStorage(this.directory);
}

abstract class CustomStorageFacade implements StorageOptions {
  /**
   * Stores string data using a custom implementation.
   */
  String? getItem(String key);

  /**
   * Get a stored entry or None if no entry is stored at the provided key
   */
  String? setItem(String key, String value);

  /**
   * Remove the entry at key
   */
  String? removeItem(String key);

}