package cp.chargeotg.gateway.mqs;

public record AuthorizationCheckEvents (String stationId,String driverToken,String callbackUrl){
}
