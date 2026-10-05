
package model.response.zion.zionLoginService;

import java.util.List;
import lombok.Data;


@Data
public class ZionLoginServiceRes {
    private List<AssignedRole> assignedRoles;
    private List<AssignedTenant> assignedTenants;
    private String emailId;
    private String rtkn;
    private String userId;
    private String userName;
}
