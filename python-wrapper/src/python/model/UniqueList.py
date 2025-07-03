from typing import List

"""
A typealias for a list of elements that shouldn't contain two equivalent elements.
Currently duplicated elements in UniqueList are ignored by the SDK.
Future versions may apply stricter checks on the items and raise exceptions in case of duplicates.  
"""
type UniqueList[T] = List[T]
