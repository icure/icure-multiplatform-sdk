import {HasEncryptionMetadata} from "../../model/base/HasEncryptionMetadata.mjs";

export class EntityWithTypeInfo<T extends HasEncryptionMetadata> {
  entity: T
  type: String

  constructor (
    entity: T,
    type: String
  ) {
    this.entity = entity
    this.type = type
  }
}