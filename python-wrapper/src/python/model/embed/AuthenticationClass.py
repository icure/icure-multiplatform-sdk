from typing import Union, Dict
from enum import Enum

class AuthenticationClass(Enum):
	DigitalId = "DIGITAL_ID"
	TwoFactorAuthentication = "TWO_FACTOR_AUTHENTICATION"
	ShortLivedToken = "SHORT_LIVED_TOKEN"
	ExternalAuthentication = "EXTERNAL_AUTHENTICATION"
	Password = "PASSWORD"
	LongLivedToken = "LONG_LIVED_TOKEN"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AuthenticationClass':
		if data == "DIGITAL_ID":
			return AuthenticationClass.DigitalId
		elif data == "TWO_FACTOR_AUTHENTICATION":
			return AuthenticationClass.TwoFactorAuthentication
		elif data == "SHORT_LIVED_TOKEN":
			return AuthenticationClass.ShortLivedToken
		elif data == "EXTERNAL_AUTHENTICATION":
			return AuthenticationClass.ExternalAuthentication
		elif data == "PASSWORD":
			return AuthenticationClass.Password
		elif data == "LONG_LIVED_TOKEN":
			return AuthenticationClass.LongLivedToken
		else:
			raise Exception(f"{data} is not a valid value for AuthenticationClass enum.")

__all__ = ['AuthenticationClass']