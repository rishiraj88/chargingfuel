package cp.chargeotg.authorization.service;

import cp.chargeotg.authorization.model.AuthorizationDecision;

public interface AuthorizationService {
    public String checkAuthorization(AuthorizationCheckEvent authorizationCheckEvent);
}
