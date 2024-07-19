import os
print(os.getcwd())

from icure.api.flavoured.PatientApi import PatientApi
from icure.api.flavoured.HealthcareElementApi import HealthcareElementApi
from icure.api.UserApi import UserApi
from icure.authentication import UsernamePassword
from icure.storage import FileSystemStorage
from icure import IcureSdk
from icure.CryptoStrategies import CryptoStrategies, KeyDataRecoveryRequest, RecoveredKeyData, ExportedKeyData, KeyGenerationRequestResult, KeyGenerationRequestResultAllow
from icure.model import DecryptedPatient, DecryptedHealthElement, SubscriptionEventType, HealthElementByHcPartyFilter, DecryptedDocument, User, DataOwnerWithType, CryptoActorStubWithType, RecoveryDataUseFailureReason, DataOwnerType, AccessLevel
import uuid
from concurrent.futures import ThreadPoolExecutor
import asyncio
from datetime import timedelta
from typing import Union, Dict, List, Callable


class MyCryptoStrategies(CryptoStrategies):
    def recover_and_verify_self_hierarchy_keys(
            self,
            keys_data: List[KeyDataRecoveryRequest],
            recover_with_icure_recovery_key: Callable[[str, bool], Union[Dict[str, Dict[str, ExportedKeyData]], RecoveryDataUseFailureReason]]
    ) -> Dict[str, RecoveredKeyData]:
        return {
            k.data_owner_details.data_owner.id: RecoveredKeyData({}, {}) for k in keys_data
        }
    def generate_new_key_for_data_owner(
            self,
            self_data_owner: DataOwnerWithType
    ) -> KeyGenerationRequestResult:
        return KeyGenerationRequestResultAllow()
    def verify_delegate_public_keys(
            self,
            delegate: CryptoActorStubWithType,
            public_keys: List[str],
    ) -> List[str]:
        return public_keys
    def data_owner_requires_anonymous_delegation(self, data_owner: CryptoActorStubWithType) -> bool:
        return data_owner.type != DataOwnerType.Hcp

executor = ThreadPoolExecutor()
sdk = IcureSdk(
    # "http://localhost:16044",
    # UsernamePassword(
    #     "hcp-a90048c4-76c6-4bee-aba9-8ce41d601da5",
    #     "50164a24-29e2-43a7-99e1-7d031185663c",
    # ),
    "https://api.icure.cloud",
    UsernamePassword(
        "luca+ginopino@icure.com",
        "948395ba-d3ac-486b-83a2-c898b88c5efe",
    ),
    FileSystemStorage("/Users/trema/icure-multiplatform-sdk/python-wrapper/build/storage"),
    MyCryptoStrategies(),
    executor=executor
)
async def demoAsync():
    patientApi = sdk.patient
    healthcareElementApi = sdk.healthcare_element
    userApi = sdk.user
    print(await sdk.icure.get_version_async())
    currentUser = await userApi.get_current_user_async()
    print(currentUser)
    selfHcpId = currentUser.healthcare_party_id
    patient = DecryptedPatient(
        id=str(uuid.uuid4()),
        first_name="Vincenzo",
        last_name="claudio_pierro",
        note="Loves python"
    )
    createdPatient = await patientApi.create_patient_async(await patientApi.with_encryption_metadata_async(patient))
    retrieved = await patientApi.get_patient_async(patient.id)
    print(retrieved)
    subscription = await healthcareElementApi.subscribe_to_events_async(
        [SubscriptionEventType.Create],
        HealthElementByHcPartyFilter(hcp_id=selfHcpId),
        None
    )
    for x in range(1, 11):
        he = await healthcareElementApi.with_encryption_metadata_async(
            base=DecryptedHealthElement(
                id=str(uuid.uuid4()),
                note=f"Something encrypted {x}",
            ),
            patient=createdPatient
        )
        createdHe = await healthcareElementApi.create_healthcare_element_async(he)
    hePages = await healthcareElementApi.find_healthcare_elements_by_hc_party_patient_async(
        selfHcpId,
        createdPatient,
    )
    print(await hePages.has_next_async())
    print(await hePages.next_async(2))
    print(await hePages.has_next_async())
    print(await hePages.next_async(10))
    print(await hePages.has_next_async())
    event = subscription.get_event()
    while event is not None:
        print(event)
        event = subscription.get_event()
    print(subscription.get_close_reason())
    print("Wait for next event with small timeout, won't complete")
    print(await subscription.wait_for_event_async(timedelta(seconds=1)))
    print("Start async wait for next event")
    nextEvent = subscription.wait_for_event_async(timedelta(seconds=10))
    nextEvent2 = subscription.wait_for_event_async(timedelta(seconds=10))
    print("Asynchronously create he")
    await healthcareElementApi.create_healthcare_element_async(await healthcareElementApi.with_encryption_metadata_async(
        base=DecryptedHealthElement(
            id=str(uuid.uuid4()),
            note=f"Last he 1",
        ),
        patient=createdPatient
    ))
    await healthcareElementApi.create_healthcare_element_async(await healthcareElementApi.with_encryption_metadata_async(
        base=DecryptedHealthElement(
            id=str(uuid.uuid4()),
            note=f"Last he 2",
        ),
        patient=createdPatient,
    ))
    print("Now wait for async next event")
    print(await nextEvent)
    print(await nextEvent2)
    subscription.close()
    print(subscription.get_close_reason())
    document = await sdk.document.create_document_async(
        await sdk.document.with_encryption_metadata_async(
            DecryptedDocument(
                id=str(uuid.uuid4()),
            ),
            None
        )
    )
    await sdk.document.encrypt_and_set_main_attachment_async(
        document=document,
        utis=["com.microsoft.windows-executable"],
        attachment=bytes(range(256))
    )
    print(await sdk.document.get_and_decrypt_main_attachment_async(
        document=document,
    ))
    print(await sdk.document.get_and_decrypt_main_attachment_async(
        document=document,
        decrypted_attachment_validator=lambda x: x[0] == 0
    ))
    print(await sdk.document.get_and_try_decrypt_main_attachment_async(
        document=document,
        decrypted_attachment_validator=lambda x: x[0] == 1
    ))

def demoBlocking():
    patientApi = sdk.patient
    healthcareElementApi = sdk.healthcare_element
    userApi = sdk.user
    print(sdk.icure.get_version_blocking())
    currentUser = userApi.get_current_user_blocking()
    print(currentUser)
    selfHcpId = currentUser.healthcare_party_id
    patient = DecryptedPatient(
        id=str(uuid.uuid4()),
        first_name="Vincenzo",
        last_name="claudio_pierro",
        note="Loves python"
    )
    createdPatient = patientApi.create_patient_blocking(patientApi.with_encryption_metadata_blocking(patient))
    retrieved = patientApi.get_patient_blocking(patient.id)
    print(retrieved)
    subscription = healthcareElementApi.subscribe_to_events_blocking(
        [SubscriptionEventType.Create],
        HealthElementByHcPartyFilter(hcp_id=selfHcpId),
        None
    )
    for x in range(1, 11):
        he = healthcareElementApi.with_encryption_metadata_blocking(
            base=DecryptedHealthElement(
                id=str(uuid.uuid4()),
                note=f"Something encrypted {x}",
            ),
            patient=createdPatient
        )
        createdHe = healthcareElementApi.create_healthcare_element_blocking(he)
    hePages = healthcareElementApi.find_healthcare_elements_by_hc_party_patient_blocking(
        selfHcpId,
        createdPatient,
    )
    print(hePages.has_next_blocking())
    print(hePages.next_blocking(2))
    print(hePages.has_next_blocking())
    print(hePages.next_blocking(10))
    print(hePages.has_next_blocking())
    event = subscription.get_event()
    while event is not None:
        print(event)
        event = subscription.get_event()
    print(subscription.get_close_reason())
    print(subscription.wait_for_event_blocking(timedelta(seconds=1)))
    subscription.close()
    print(subscription.get_close_reason())
    document = sdk.document.create_document_blocking(
        sdk.document.with_encryption_metadata_blocking(
            DecryptedDocument(
                id=str(uuid.uuid4()),
            ),
            None
        )
    )
    print(document.id)
    sdk.document.encrypt_and_set_main_attachment_blocking(
        document=document,
        utis=["com.microsoft.windows-executable"],
        attachment=bytes(range(256))
    )
    print(sdk.document.get_and_decrypt_main_attachment_blocking(
        document=document,
    ))
    print(sdk.document.get_and_decrypt_main_attachment_blocking(
        document=document,
        decrypted_attachment_validator=lambda x: x[0] == 0
    ))
    print(sdk.document.get_and_try_decrypt_main_attachment_blocking(
        document=document,
        decrypted_attachment_validator=lambda x: x[0] == 1
    ))
    old_doc = sdk.document.get_document_blocking("60707056-385b-4fa4-88f1-55ca86327bab")
    print(sdk.document.get_and_decrypt_main_attachment_blocking(
        document=old_doc,
        decrypted_attachment_validator=lambda x: x[0] == 0
    ))

asyncio.run(demoAsync())
# demoBlocking()
