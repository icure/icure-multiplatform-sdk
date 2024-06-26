import json
from typing import Optional, List, Dict, Union
from model.couchdb.Remote import Remote
from model.couchdb.ReplicationStats import ReplicationStats
from dataclasses import dataclass

@dataclass
class ReplicatorDocument:
	id: str
	rev: Optional[str] = None
	source: Optional['Remote'] = None
	target: Optional['Remote'] = None
	owner: Optional[str] = None
	create_target: Optional[bool] = None
	continuous: Optional[bool] = None
	doc_ids: Optional[List[str]] = None
	replication_state: Optional[str] = None
	replication_state_time: Optional[str] = None
	replication_stats: Optional['ReplicationStats'] = None
	error_count: Optional[int] = None
	revs_info: Optional[List[Dict[str, str]]] = None
	rev_history: Optional[Dict[str, str]] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"source": self.source.__serialize__() if self.source is not None else None,
			"target": self.target.__serialize__() if self.target is not None else None,
			"owner": self.owner,
			"create_target": self.create_target,
			"continuous": self.continuous,
			"doc_ids": [x0 for x0 in self.doc_ids] if self.doc_ids is not None else None,
			"replicationState": self.replication_state,
			"replicationStateTime": self.replication_state_time,
			"replicationStats": self.replication_stats.__serialize__() if self.replication_stats is not None else None,
			"errorCount": self.error_count,
			"revsInfo": [{k1: v1 for k1, v1 in x0.items()} for x0 in self.revs_info] if self.revs_info is not None else None,
			"revHistory": {k0: v0 for k0, v0 in self.rev_history.items()} if self.rev_history is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReplicatorDocument':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			source = Remote._deserialize(deserialized_dict.get("source")) if deserialized_dict.get("source") is not None else None,
			target = Remote._deserialize(deserialized_dict.get("target")) if deserialized_dict.get("target") is not None else None,
			owner = deserialized_dict.get("owner"),
			create_target = deserialized_dict.get("create_target"),
			continuous = deserialized_dict.get("continuous"),
			doc_ids = [x0 for x0 in deserialized_dict.get("doc_ids")] if deserialized_dict.get("doc_ids") is not None else None,
			replication_state = deserialized_dict.get("replicationState"),
			replication_state_time = deserialized_dict.get("replicationStateTime"),
			replication_stats = ReplicationStats._deserialize(deserialized_dict.get("replicationStats")) if deserialized_dict.get("replicationStats") is not None else None,
			error_count = deserialized_dict.get("errorCount"),
			revs_info = [dict(map(lambda kv1: (kv1[0], kv1[1]), x0.items())) for x0 in deserialized_dict.get("revsInfo")] if deserialized_dict.get("revsInfo") is not None else None,
			rev_history = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("revHistory").items())) if deserialized_dict.get("revHistory") is not None else None,
		)

__all__ = ['ReplicatorDocument']