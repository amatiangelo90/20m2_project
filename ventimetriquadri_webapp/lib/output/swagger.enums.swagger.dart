import 'package:json_annotation/json_annotation.dart';

enum ROrderProductUnitMeasure {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('PACCHI')
  pacchi,
  @JsonValue('UNITA')
  unita,
  @JsonValue('KG')
  kg,
  @JsonValue('LITRI')
  litri,
  @JsonValue('CARTONI')
  cartoni
}

const $ROrderProductUnitMeasureMap = {
  ROrderProductUnitMeasure.pacchi: 'PACCHI',
  ROrderProductUnitMeasure.unita: 'UNITA',
  ROrderProductUnitMeasure.kg: 'KG',
  ROrderProductUnitMeasure.litri: 'LITRI',
  ROrderProductUnitMeasure.cartoni: 'CARTONI'
};

enum RWorkstationProductUnitMeasure {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('PACCHI')
  pacchi,
  @JsonValue('UNITA')
  unita,
  @JsonValue('KG')
  kg,
  @JsonValue('LITRI')
  litri,
  @JsonValue('CARTONI')
  cartoni
}

const $RWorkstationProductUnitMeasureMap = {
  RWorkstationProductUnitMeasure.pacchi: 'PACCHI',
  RWorkstationProductUnitMeasure.unita: 'UNITA',
  RWorkstationProductUnitMeasure.kg: 'KG',
  RWorkstationProductUnitMeasure.litri: 'LITRI',
  RWorkstationProductUnitMeasure.cartoni: 'CARTONI'
};

enum CustomerAccessBranchLocation {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('CISTERNINO')
  cisternino,
  @JsonValue('LOCOROTONDO')
  locorotondo,
  @JsonValue('MONOPOLI')
  monopoli
}

const $CustomerAccessBranchLocationMap = {
  CustomerAccessBranchLocation.cisternino: 'CISTERNINO',
  CustomerAccessBranchLocation.locorotondo: 'LOCOROTONDO',
  CustomerAccessBranchLocation.monopoli: 'MONOPOLI'
};

enum RStorageProductUnitMeasure {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('PACCHI')
  pacchi,
  @JsonValue('UNITA')
  unita,
  @JsonValue('KG')
  kg,
  @JsonValue('LITRI')
  litri,
  @JsonValue('CARTONI')
  cartoni
}

const $RStorageProductUnitMeasureMap = {
  RStorageProductUnitMeasure.pacchi: 'PACCHI',
  RStorageProductUnitMeasure.unita: 'UNITA',
  RStorageProductUnitMeasure.kg: 'KG',
  RStorageProductUnitMeasure.litri: 'LITRI',
  RStorageProductUnitMeasure.cartoni: 'CARTONI'
};

enum ProductUnitMeasure {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('PACCHI')
  pacchi,
  @JsonValue('UNITA')
  unita,
  @JsonValue('KG')
  kg,
  @JsonValue('LITRI')
  litri,
  @JsonValue('CARTONI')
  cartoni
}

const $ProductUnitMeasureMap = {
  ProductUnitMeasure.pacchi: 'PACCHI',
  ProductUnitMeasure.unita: 'UNITA',
  ProductUnitMeasure.kg: 'KG',
  ProductUnitMeasure.litri: 'LITRI',
  ProductUnitMeasure.cartoni: 'CARTONI'
};

enum WorkstationWorkstationStatus {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('APERTO')
  aperto,
  @JsonValue('CHIUSO')
  chiuso
}

const $WorkstationWorkstationStatusMap = {
  WorkstationWorkstationStatus.aperto: 'APERTO',
  WorkstationWorkstationStatus.chiuso: 'CHIUSO'
};

enum WorkstationWorkstationType {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('BAR')
  bar,
  @JsonValue('CHAMPAGNERIE')
  champagnerie
}

const $WorkstationWorkstationTypeMap = {
  WorkstationWorkstationType.bar: 'BAR',
  WorkstationWorkstationType.champagnerie: 'CHAMPAGNERIE'
};

enum OrderEntityOrderStatus {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('INVIATO')
  inviato,
  @JsonValue('NON_INVIATO')
  nonInviato,
  @JsonValue('RICEVUTO')
  ricevuto,
  @JsonValue('NON_RICEVUTO')
  nonRicevuto
}

const $OrderEntityOrderStatusMap = {
  OrderEntityOrderStatus.inviato: 'INVIATO',
  OrderEntityOrderStatus.nonInviato: 'NON_INVIATO',
  OrderEntityOrderStatus.ricevuto: 'RICEVUTO',
  OrderEntityOrderStatus.nonRicevuto: 'NON_RICEVUTO'
};

enum BranchUserPriviledge {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('SUPER_ADMIN')
  superAdmin,
  @JsonValue('ADMIN')
  admin,
  @JsonValue('SOCIO')
  socio,
  @JsonValue('EMPLOYEE')
  employee,
  @JsonValue('BARMAN')
  barman
}

const $BranchUserPriviledgeMap = {
  BranchUserPriviledge.superAdmin: 'SUPER_ADMIN',
  BranchUserPriviledge.admin: 'ADMIN',
  BranchUserPriviledge.socio: 'SOCIO',
  BranchUserPriviledge.employee: 'EMPLOYEE',
  BranchUserPriviledge.barman: 'BARMAN'
};

enum EventEventStatus {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('APERTO')
  aperto,
  @JsonValue('CHIUSO')
  chiuso
}

const $EventEventStatusMap = {
  EventEventStatus.aperto: 'APERTO',
  EventEventStatus.chiuso: 'CHIUSO'
};
