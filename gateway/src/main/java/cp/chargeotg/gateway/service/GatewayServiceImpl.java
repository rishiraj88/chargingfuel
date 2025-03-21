package cp.chargeotg.gateway.service;

import cp.chargeotg.gateway.common.Constants;
import cp.chargeotg.gateway.dto.ChargingSessionReq;
import cp.chargeotg.gateway.dto.ChargingSessionResp;
import cp.chargeotg.mq.AuthorizationCheckEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@Slf4j
public class GatewayServiceImpl implements GatewayService {
    private final KafkaTemplate<String, AuthorizationCheckEvent> kafkaTemplate;

    public GatewayServiceImpl(KafkaTemplate<String, AuthorizationCheckEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public ChargingSessionResp createChargingSession(ChargingSessionReq chargingSessionReq) {
        /*
        forward to auth service the following, via message queue:
        station id, driver id, callback url
        */
        log.info("Requesting authorization for driver {} at station {}...", chargingSessionReq.driverId(), chargingSessionReq.stationUuid());

        //use event for invocation of auth service
        var authorizationCheckEvent = new AuthorizationCheckEvent(chargingSessionReq.stationUuid().toString(), chargingSessionReq.driverId(), chargingSessionReq.callbackUrl().toString());
        Properties props = new Properties();
        props.put("schema.registry.url","http://127.0.0.1:8081");
        //KafkaProducer kafkaProducer = new KafkaProducer(props);
        //kafkaProducer.send(Constants.AUTHORIZATION_CHECK_QUEUE_NAME, authorizationCheckEvent);
        kafkaTemplate.send(Constants.AUTHORIZATION_CHECK_QUEUE_NAME, authorizationCheckEvent);
        log.info("Requested authorization for driver {} at station {}...", chargingSessionReq.driverId(), chargingSessionReq.stationUuid());

        return new ChargingSessionResp("accepted", "Request is being processed asynchronously. The result will be sent to the provided callback URL.");         // Auth service sends the decision to callback url.
    }
}
