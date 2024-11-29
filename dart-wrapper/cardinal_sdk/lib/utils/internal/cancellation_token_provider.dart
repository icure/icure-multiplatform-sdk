class CancellationTokenProvider {
  static int _count = 0;
  static int getNextToken() {
    final res = _count;
    if (_count == 9007199254740991) { // js-safe overflow
      _count = -9007199254740991;
    } else {
      _count += 1;
    }
    return res;
  }
}