from typing import Generic, TypeVar, List, Optional, Callable
from ctypes import c_void_p

T = TypeVar('T')

class PaginatedListIterator(Generic[T]):

    def __init__(self, producer: c_void_p, deserializer: Callable[[str], T]):
        self.producer = producer
        self.deserializer = deserializer

    def has_next_blocking(self, size: Optional[int] = None) -> bool:
        TODO()

    def has_next_async(self, size: Optional[int] = None) -> bool:
        TODO()

    def next_async(self, size: int = 1) -> List[T]:
        TODO()

    def next_blocking(self, size: int = 1) -> List[T]:
        TODO()

