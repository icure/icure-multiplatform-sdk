from typing import Union
from datetime import timedelta


def serialize_timedelta(delta: timedelta) -> object:
    return int(delta/timedelta(milliseconds=1))


def deserialize_timedelta(data: Union[int, str]) -> timedelta:
    milliseconds: int
    if isinstance(data, int):
        milliseconds = data
    else:
        milliseconds = int(data)
    return timedelta(milliseconds=milliseconds)