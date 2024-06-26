from typing import Union, Dict
from enum import Enum

class TypedValuesType(Enum):
	Boolean = "BOOLEAN"
	Integer = "INTEGER"
	Double = "DOUBLE"
	String = "STRING"
	Date = "DATE"
	Clob = "CLOB"
	Json = "JSON"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TypedValuesType':
		if data == "BOOLEAN":
			return TypedValuesType.Boolean
		elif data == "INTEGER":
			return TypedValuesType.Integer
		elif data == "DOUBLE":
			return TypedValuesType.Double
		elif data == "STRING":
			return TypedValuesType.String
		elif data == "DATE":
			return TypedValuesType.Date
		elif data == "CLOB":
			return TypedValuesType.Clob
		elif data == "JSON":
			return TypedValuesType.Json
		else:
			raise Exception(f"{data} is not a valid value for TypedValuesType enum.")

__all__ = ['TypedValuesType']