// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../../model/Message.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {MessageFlavouredApi} from './MessageFlavouredApi.mjs';


export interface MessageApi {

	encrypted: MessageFlavouredApi<EncryptedMessage>;

	tryAndRecover: MessageFlavouredApi<Message>;

	createMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	withEncryptionMetadata(
			base: DecryptedMessage | undefined,
			patient: Patient | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedMessage>;

	createMessageInTopic(entity: DecryptedMessage): Promise<DecryptedMessage>;

	matchMessagesBy(filter: AbstractFilter<EncryptedMessage>): Promise<Array<string>>;

	deleteMessage(entityId: string): Promise<DocIdentifier>;

	deleteMessages(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			message: DecryptedMessage,
			shareSecretIds: Array<string>,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedMessage>>;

	findMessagesByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedMessage>>;

}
