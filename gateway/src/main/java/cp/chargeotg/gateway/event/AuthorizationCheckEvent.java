package cp.chargeotg.gateway.event;

public record AuthorizationCheckEvent(
     String stationId,
     String driverToken,
     String callbackUrl){
}
