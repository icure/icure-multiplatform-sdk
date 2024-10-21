// This file is auto-generated


enum DocumentStatus {
	draft,
	finalized,
	pendingReview,
	reviewed,
	pendingSignature,
	signed,
	canceled,
	sent,
	delivered;

	static String encode(DocumentStatus value) {
		switch (value) {
			case DocumentStatus.draft:
				return '"Draft"';
			case DocumentStatus.finalized:
				return '"Finalized"';
			case DocumentStatus.pendingReview:
				return '"PendingReview"';
			case DocumentStatus.reviewed:
				return '"Reviewed"';
			case DocumentStatus.pendingSignature:
				return '"PendingSignature"';
			case DocumentStatus.signed:
				return '"Signed"';
			case DocumentStatus.canceled:
				return '"Canceled"';
			case DocumentStatus.sent:
				return '"Sent"';
			case DocumentStatus.delivered:
				return '"Delivered"';
			}
	}

}