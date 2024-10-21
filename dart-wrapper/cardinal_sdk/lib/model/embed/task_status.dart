// This file is auto-generated


enum TaskStatus {
	pending,
	ongoing,
	cancelled,
	completed;

	static String encode(TaskStatus value) {
		switch (value) {
			case TaskStatus.pending:
				return '"Pending"';
			case TaskStatus.ongoing:
				return '"Ongoing"';
			case TaskStatus.cancelled:
				return '"Cancelled"';
			case TaskStatus.completed:
				return '"Completed"';
			}
	}

}