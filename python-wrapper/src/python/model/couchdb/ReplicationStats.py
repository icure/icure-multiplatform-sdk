import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ReplicationStats:
	revisions_checked: Optional[int] = None
	missing_revisions_found: Optional[int] = None
	docs_read: Optional[int] = None
	docs_written: Optional[int] = None
	changes_pending: Optional[int] = None
	doc_write_failures: Optional[int] = None
	checkpointed_source_seq: Optional[str] = None
	start_time: Optional[str] = None
	error: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"revisionsChecked": self.revisions_checked,
			"missingRevisionsFound": self.missing_revisions_found,
			"docsRead": self.docs_read,
			"docsWritten": self.docs_written,
			"changesPending": self.changes_pending,
			"docWriteFailures": self.doc_write_failures,
			"checkpointedSourceSeq": self.checkpointed_source_seq,
			"startTime": self.start_time,
			"error": self.error,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReplicationStats':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			revisions_checked = deserialized_dict.get("revisionsChecked"),
			missing_revisions_found = deserialized_dict.get("missingRevisionsFound"),
			docs_read = deserialized_dict.get("docsRead"),
			docs_written = deserialized_dict.get("docsWritten"),
			changes_pending = deserialized_dict.get("changesPending"),
			doc_write_failures = deserialized_dict.get("docWriteFailures"),
			checkpointed_source_seq = deserialized_dict.get("checkpointedSourceSeq"),
			start_time = deserialized_dict.get("startTime"),
			error = deserialized_dict.get("error"),
		)

__all__ = ['ReplicationStats']