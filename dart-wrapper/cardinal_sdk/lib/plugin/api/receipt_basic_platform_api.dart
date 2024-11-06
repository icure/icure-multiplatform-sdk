// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'dart:convert';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/receipt.dart';


class ReceiptBasicPlatformApi {
	MethodChannel _methodChannel;
	ReceiptBasicPlatformApi(this._methodChannel);

	Future<DocIdentifier> deleteReceipt(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.deleteReceipt',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteReceipt");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteReceipts(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.deleteReceipts',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteReceipts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<Uint8List> getRawReceiptAttachment(String sdkId, String receiptId, String attachmentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.getRawReceiptAttachment',
			{
				"sdkId": sdkId,
				"receiptId": jsonEncode(receiptId),
				"attachmentId": jsonEncode(attachmentId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getRawReceiptAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedReceipt> setRawReceiptAttachment(String sdkId, String receiptId, String rev, String blobType, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.setRawReceiptAttachment',
			{
				"sdkId": sdkId,
				"receiptId": jsonEncode(receiptId),
				"rev": jsonEncode(rev),
				"blobType": jsonEncode(blobType),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setRawReceiptAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<EncryptedReceipt> modifyReceipt(String sdkId, EncryptedReceipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.modifyReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedReceipt.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyReceipt");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<EncryptedReceipt> getReceipt(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.getReceipt',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getReceipt");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<List<EncryptedReceipt>> listByReference(String sdkId, String reference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptBasicApi.listByReference',
			{
				"sdkId": sdkId,
				"reference": jsonEncode(reference),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listByReference");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedReceipt.fromJSON(x1) ).toList();
	}
}