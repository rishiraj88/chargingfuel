package cp.chargeotg.authorization.event;

public record AuthorizationCheckEvents(
     String stationId,
     String driverToken,
     String callbackUrl){
}
