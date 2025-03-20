package cp.chargeotg.authorization.service;

import cp.chargeotg.authorization.event.AuthorizationCheckEvent;
import cp.chargeotg.authorization.model.AuthorizationDecision;
import org.springframework.kafka.annotation.KafkaListener;

public interface AuthorizationService {
    @KafkaListener(topics = "authz-check")
    AuthorizationDecision checkAuthorization(AuthorizationCheckEvent authorizationCheckEvent);
}
