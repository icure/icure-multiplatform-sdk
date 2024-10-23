// auto-generated file


enum TaskStatus {
	pending,
	ongoing,
	cancelled,
	completed;

	static String encode(TaskStatus value) {
		switch (value) {
			case TaskStatus.pending:
				return '"pending"';
			case TaskStatus.ongoing:
				return '"ongoing"';
			case TaskStatus.cancelled:
				return '"cancelled"';
			case TaskStatus.completed:
				return '"completed"';
			}
	}


	static TaskStatus fromJSON(String data) {
		switch (data) {
			case "pending":
				return TaskStatus.pending;
			case "ongoing":
				return TaskStatus.ongoing;
			case "cancelled":
				return TaskStatus.cancelled;
			case "completed":
				return TaskStatus.completed;
			default:
				throw ArgumentError('Invalid TaskStatus entry value $data');
			}
	}

}