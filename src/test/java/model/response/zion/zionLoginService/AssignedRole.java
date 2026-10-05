
package model.response.zion.zionLoginService;

import java.util.List;
import lombok.Data;


@Data
public class AssignedRole {
    private String createdAt;
    private List<String> permissionTypeList;
    private String roleId;
    private String roleName;
    private List<Object> servicePermissionsList;
    private String updatedAt;
    private String updatedBy;
}
