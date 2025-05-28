from typing import Union, Any

type JsonElement = Union[
	None,
	bool,
	int,
	float,
	str,
	list["JsonElement"],
	dict[str, "JsonElement"],
]
