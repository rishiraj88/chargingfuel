package cp.chargeotg.authorization.event;

public record AuthorizationCheckEvent(
     String stationId,
     String driverToken,
     String callbackUrl){
}
