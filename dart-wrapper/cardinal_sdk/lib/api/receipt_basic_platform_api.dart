// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/receipt.dart';


class ReceiptBasicPlatformApi {
	String _sdkId;
	ReceiptBasicPlatformApi(this._sdkId);

	Future<DocIdentifier> deleteReceipt(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.deleteReceipt(
			_sdkId,
			entityId,
		);
	}

	Future<List<DocIdentifier>> deleteReceipts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.deleteReceipts(
			_sdkId,
			entityIds,
		);
	}

	Future<Uint8List> getRawReceiptAttachment(String receiptId, String attachmentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.getRawReceiptAttachment(
			_sdkId,
			receiptId,
			attachmentId,
		);
	}

	Future<EncryptedReceipt> setRawReceiptAttachment(String receiptId, String rev, String blobType, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.setRawReceiptAttachment(
			_sdkId,
			receiptId,
			rev,
			blobType,
			attachment,
		);
	}

	Future<EncryptedReceipt> modifyReceipt(EncryptedReceipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.modifyReceipt(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedReceipt> getReceipt(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.getReceipt(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedReceipt>> listByReference(String reference) async {
		return await CardinalSdkPlatformInterface.instance.apis.receiptBasic.listByReference(
			_sdkId,
			reference,
		);
	}
}