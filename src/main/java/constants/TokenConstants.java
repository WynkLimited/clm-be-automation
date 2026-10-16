package constants;

public final class TokenConstants {

    private TokenConstants() {}

    public static final String USER_ID_KEY = "x-user-id";
    public static final String USR_ID_KEY = "x-usr-id";
    public static final String TENANT_ID_KEY = "x-tenant-id";
    public static final String TENANT_NAME_KEY = "x-tenant-name";
    public static final String ROLE_ID_KEY = "x-role-id";
    public static final String WORKSPACE_ID_KEY = "x-workspace-id";
    public static final String USER_HIERARCHY_KEY = "x-user-hierarchy";
    public static final String SESSION_ID_KEY = "session_id";
    public static final String HIERARCHY_SEPARATOR = "->";

    /** Serenity session key holding the generated Bearer JWT for API calls. */
    public static final String AUTH_TOKEN_SESSION_KEY = "clmAuthToken";
}
