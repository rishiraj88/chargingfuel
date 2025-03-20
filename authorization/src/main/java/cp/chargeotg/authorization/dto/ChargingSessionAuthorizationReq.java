package cp.chargeotg.authorization.dto;

import java.net.URL;
import java.util.UUID;

public record ChargingSessionAuthorizationReq(UUID stationUuid,
                                              String driverToken, URL callbackUrl) {
}
