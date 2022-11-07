import 'package:json_annotation/json_annotation.dart';

enum CustomersBranch20m2 {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('CISTERNINO')
  cisternino,
  @JsonValue('LOCOROTONDO')
  locorotondo,
  @JsonValue('MONOPOLI')
  monopoli
}

const $CustomersBranch20m2Map = {
  CustomersBranch20m2.cisternino: 'CISTERNINO',
  CustomersBranch20m2.locorotondo: 'LOCOROTONDO',
  CustomersBranch20m2.monopoli: 'MONOPOLI'
};

enum EventEventStatus {
  @JsonValue('swaggerGeneratedUnknown')
  swaggerGeneratedUnknown,
  @JsonValue('OPEN')
  open,
  @JsonValue('CLOSED')
  closed
}

const $EventEventStatusMap = {
  EventEventStatus.open: 'OPEN',
  EventEventStatus.closed: 'CLOSED'
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
