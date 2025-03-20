package cp.chargeotg.authorization.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(value = "product")
public class AuthorizationDecision {
    @Id
    private String id;
    private String stationId;
    private String driverToken;
    private String status; // Category may be inferred out of SKU code

    public AuthorizationDecision(String stationId, String driverToken, String status) {
      this.stationId = stationId;
      this.driverToken = driverToken;
      this.status = status;
    }
}
