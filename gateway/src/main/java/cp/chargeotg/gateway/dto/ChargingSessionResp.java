package cp.chargeotg.gateway.dto;

public record ChargingSessionResp(String status, String message) {
    public ChargingSessionResp(String status, String message){
        this.status = status;
        this.message = message;
    }
}
