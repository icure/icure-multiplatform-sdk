// auto-generated file

export class FlowItem {

  id: string | undefined = undefined;

  title: string | undefined = undefined;

  comment: string | undefined = undefined;

  receptionDate: number | undefined = undefined;

  processingDate: number | undefined = undefined;

  processer: string | undefined = undefined;

  cancellationDate: number | undefined = undefined;

  canceller: string | undefined = undefined;

  cancellationReason: string | undefined = undefined;

  cancellationNote: string | undefined = undefined;

  status: string | undefined = undefined;

  homeVisit: boolean | undefined = undefined;

  municipality: string | undefined = undefined;

  town: string | undefined = undefined;

  zipCode: string | undefined = undefined;

  street: string | undefined = undefined;

  building: string | undefined = undefined;

  buildingNumber: string | undefined = undefined;

  doorbellName: string | undefined = undefined;

  floor: string | undefined = undefined;

  letterBox: string | undefined = undefined;

  notesOps: string | undefined = undefined;

  notesContact: string | undefined = undefined;

  latitude: string | undefined = undefined;

  longitude: string | undefined = undefined;

  type: string | undefined = undefined;

  emergency: boolean | undefined = undefined;

  phoneNumber: string | undefined = undefined;

  patientId: string | undefined = undefined;

  patientLastName: string | undefined = undefined;

  patientFirstName: string | undefined = undefined;

  description: string | undefined = undefined;

  interventionCode: string | undefined = undefined;

  constructor(partial: Partial<FlowItem>) {
    if ('id' in partial) this.id = partial.id;
    if ('title' in partial) this.title = partial.title;
    if ('comment' in partial) this.comment = partial.comment;
    if ('receptionDate' in partial) this.receptionDate = partial.receptionDate;
    if ('processingDate' in partial) this.processingDate = partial.processingDate;
    if ('processer' in partial) this.processer = partial.processer;
    if ('cancellationDate' in partial) this.cancellationDate = partial.cancellationDate;
    if ('canceller' in partial) this.canceller = partial.canceller;
    if ('cancellationReason' in partial) this.cancellationReason = partial.cancellationReason;
    if ('cancellationNote' in partial) this.cancellationNote = partial.cancellationNote;
    if ('status' in partial) this.status = partial.status;
    if ('homeVisit' in partial) this.homeVisit = partial.homeVisit;
    if ('municipality' in partial) this.municipality = partial.municipality;
    if ('town' in partial) this.town = partial.town;
    if ('zipCode' in partial) this.zipCode = partial.zipCode;
    if ('street' in partial) this.street = partial.street;
    if ('building' in partial) this.building = partial.building;
    if ('buildingNumber' in partial) this.buildingNumber = partial.buildingNumber;
    if ('doorbellName' in partial) this.doorbellName = partial.doorbellName;
    if ('floor' in partial) this.floor = partial.floor;
    if ('letterBox' in partial) this.letterBox = partial.letterBox;
    if ('notesOps' in partial) this.notesOps = partial.notesOps;
    if ('notesContact' in partial) this.notesContact = partial.notesContact;
    if ('latitude' in partial) this.latitude = partial.latitude;
    if ('longitude' in partial) this.longitude = partial.longitude;
    if ('type' in partial) this.type = partial.type;
    if ('emergency' in partial) this.emergency = partial.emergency;
    if ('phoneNumber' in partial) this.phoneNumber = partial.phoneNumber;
    if ('patientId' in partial) this.patientId = partial.patientId;
    if ('patientLastName' in partial) this.patientLastName = partial.patientLastName;
    if ('patientFirstName' in partial) this.patientFirstName = partial.patientFirstName;
    if ('description' in partial) this.description = partial.description;
    if ('interventionCode' in partial) this.interventionCode = partial.interventionCode;
  }

}
