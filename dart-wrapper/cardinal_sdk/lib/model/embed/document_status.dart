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
				return '"draft"';
			case DocumentStatus.finalized:
				return '"finalized"';
			case DocumentStatus.pendingReview:
				return '"pending_review"';
			case DocumentStatus.reviewed:
				return '"reviewed"';
			case DocumentStatus.pendingSignature:
				return '"pending_signature"';
			case DocumentStatus.signed:
				return '"signed"';
			case DocumentStatus.canceled:
				return '"canceled"';
			case DocumentStatus.sent:
				return '"sent"';
			case DocumentStatus.delivered:
				return '"delivered"';
			}
	}


	static DocumentStatus fromJSON(String data) {
		switch (data) {
			case "draft":
				return DocumentStatus.draft;
			case "finalized":
				return DocumentStatus.finalized;
			case "pending_review":
				return DocumentStatus.pendingReview;
			case "reviewed":
				return DocumentStatus.reviewed;
			case "pending_signature":
				return DocumentStatus.pendingSignature;
			case "signed":
				return DocumentStatus.signed;
			case "canceled":
				return DocumentStatus.canceled;
			case "sent":
				return DocumentStatus.sent;
			case "delivered":
				return DocumentStatus.delivered;
			default:
				throw ArgumentError('Invalid DocumentStatus entry value $data');
			}
	}

}