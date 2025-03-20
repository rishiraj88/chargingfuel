package cp.chargeotg.authorization;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController @Slf4j
@RequestMapping("/api/v1/authz")
public class AuthorizationController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestBody ChargingSessionAuthorizationReq chargingSessionAuthorizationReq) {
        log.info("Checking authorization status for driver: "+ chargingSessionAuthorizationReq.driverToken());
        return null; //authorizationService.checkAuthorization()
    }
}
