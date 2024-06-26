import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass
from model.embed.TimeTableHour import TimeTableHour

@dataclass
class TimeTableItem:
	rrule_start_date: Optional[int] = None
	rrule: Optional[str] = None
	not_before_in_minutes: Optional[int] = None
	not_after_in_minutes: Optional[int] = None
	zone_id: Optional[str] = None
	days: List[str] = field(default_factory=list)
	recurrence_types: List[str] = field(default_factory=list)
	hours: List['TimeTableHour'] = field(default_factory=list)
	calendar_item_type_id: Optional[str] = None
	home_visit: bool = False
	place_id: Optional[str] = None
	public_time_table_item: bool = False
	accepts_new_patient: bool = True
	unavailable: bool = False

	def __serialize__(self) -> object:
		return {
			"rruleStartDate": self.rrule_start_date,
			"rrule": self.rrule,
			"notBeforeInMinutes": self.not_before_in_minutes,
			"notAfterInMinutes": self.not_after_in_minutes,
			"zoneId": self.zone_id,
			"days": [x0 for x0 in self.days],
			"recurrenceTypes": [x0 for x0 in self.recurrence_types],
			"hours": [x0.__serialize__() for x0 in self.hours],
			"calendarItemTypeId": self.calendar_item_type_id,
			"homeVisit": self.home_visit,
			"placeId": self.place_id,
			"publicTimeTableItem": self.public_time_table_item,
			"acceptsNewPatient": self.accepts_new_patient,
			"unavailable": self.unavailable,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeTableItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			rrule_start_date = deserialized_dict.get("rruleStartDate"),
			rrule = deserialized_dict.get("rrule"),
			not_before_in_minutes = deserialized_dict.get("notBeforeInMinutes"),
			not_after_in_minutes = deserialized_dict.get("notAfterInMinutes"),
			zone_id = deserialized_dict.get("zoneId"),
			days = [x0 for x0 in deserialized_dict["days"]],
			recurrence_types = [x0 for x0 in deserialized_dict["recurrenceTypes"]],
			hours = [TimeTableHour._deserialize(x0) for x0 in deserialized_dict["hours"]],
			calendar_item_type_id = deserialized_dict.get("calendarItemTypeId"),
			home_visit = deserialized_dict["homeVisit"],
			place_id = deserialized_dict.get("placeId"),
			public_time_table_item = deserialized_dict["publicTimeTableItem"],
			accepts_new_patient = deserialized_dict["acceptsNewPatient"],
			unavailable = deserialized_dict["unavailable"],
		)

__all__ = ['TimeTableItem']