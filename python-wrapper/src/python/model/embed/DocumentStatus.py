from typing import Union, Dict
from enum import Enum

class DocumentStatus(Enum):
	Draft = "draft"
	Finalized = "finalized"
	PendingReview = "pending_review"
	Reviewed = "reviewed"
	PendingSignature = "pending_signature"
	Signed = "signed"
	Canceled = "canceled"
	Sent = "sent"
	Delivered = "delivered"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentStatus':
		if data == "draft":
			return DocumentStatus.Draft
		elif data == "finalized":
			return DocumentStatus.Finalized
		elif data == "pending_review":
			return DocumentStatus.PendingReview
		elif data == "reviewed":
			return DocumentStatus.Reviewed
		elif data == "pending_signature":
			return DocumentStatus.PendingSignature
		elif data == "signed":
			return DocumentStatus.Signed
		elif data == "canceled":
			return DocumentStatus.Canceled
		elif data == "sent":
			return DocumentStatus.Sent
		elif data == "delivered":
			return DocumentStatus.Delivered
		else:
			raise Exception(f"{data} is not a valid value for DocumentStatus enum.")

__all__ = ['DocumentStatus']