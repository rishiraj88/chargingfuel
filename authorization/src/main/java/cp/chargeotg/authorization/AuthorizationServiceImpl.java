package cp.chargeotg.authorization;

import cp.chargeotg.authorization.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    @KafkaListener(topics = "authz-check")
    public String checkAuthorization(AuthorizatiokafknCheckEvent authorizationCheckEvent) {
        log.info("Got a message out of 'order-placed' topic {}", authorizationCheckEvent);

        return null; //authorizationDecisionRepo.save(new decision);

    }

}