package utilities;

import com.typesafe.config.Config;
import config.ConfigLoader;
import constants.TokenConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Test-side JWT helper adapted from auth-manager JwtUtility.
 * Signs tokens with HS256 using jwt.secret from env.conf (or -Djwt.secret).
 */
public final class JwtTokenUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final Config conf = ConfigLoader.load();

    private JwtTokenUtil() {}

    /**
     * Creates a token using claim defaults from env.conf (jwt.user.*).
     */
    public static String createToken() {
        String username = conf.getString("jwt.user.username");
        Map<String, Object> claims = buildDefaultClaims(username);
        return createToken(claims, username);
    }

    /**
     * Creates a token with explicit CLM auth claims (same keys as auth-manager).
     */
    public static String createToken(String username,
                                    String tenantId,
                                    String tenantName,
                                    String roleId,
                                    String workspaceId,
                                    String userHierarchy,
                                    String sessionId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(TokenConstants.USER_ID_KEY, username);
        claims.put(TokenConstants.USR_ID_KEY, username);
        claims.put(TokenConstants.TENANT_ID_KEY, tenantId);
        claims.put(TokenConstants.TENANT_NAME_KEY, tenantName);
        claims.put(TokenConstants.ROLE_ID_KEY, roleId);
        claims.put(TokenConstants.WORKSPACE_ID_KEY, workspaceId);
        claims.put(TokenConstants.USER_HIERARCHY_KEY, userHierarchy);
        claims.put(TokenConstants.SESSION_ID_KEY,
                sessionId == null || sessionId.isBlank() ? UUID.randomUUID().toString() : sessionId);
        return createToken(claims, username);
    }

    /**
     * Creates a token with a custom claims map (mirrors generateTokenWithClaims).
     */
    public static String createToken(Map<String, Object> claims, String username) {
        try {
            long validityMs = Long.parseLong(resolveTokenValidity());
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(username)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                    .signWith(getSignKey(), SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception ex) {
            log.error("Error creating JWT token", ex);
            throw new RuntimeException("Could not generate JWT token", ex);
        }
    }

    private static Map<String, Object> buildDefaultClaims(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(TokenConstants.USER_ID_KEY, username);
        claims.put(TokenConstants.USR_ID_KEY, username);
        claims.put(TokenConstants.TENANT_ID_KEY, conf.getString("jwt.user.tenantId"));
        claims.put(TokenConstants.TENANT_NAME_KEY, conf.getString("jwt.user.tenantName"));
        claims.put(TokenConstants.ROLE_ID_KEY, conf.getString("jwt.user.roleId"));
        claims.put(TokenConstants.WORKSPACE_ID_KEY, conf.getString("jwt.user.workspaceId"));
        claims.put(TokenConstants.USER_HIERARCHY_KEY, conf.getString("jwt.user.hierarchy"));
        claims.put(TokenConstants.SESSION_ID_KEY, UUID.randomUUID().toString());
        return claims;
    }

    private static Key getSignKey() {
        String secret = resolveSecret();
        if (secret.contains("REPLACE_WITH") || secret.equalsIgnoreCase("changeme")) {
            throw new IllegalStateException(
                    "jwt.secret is still a placeholder in env.conf. "
                            + "Set it to the Base64 value from auth-manager (jwt.secret), "
                            + "or run with -Djwt.secret=<base64-secret>");
        }
        try {
            byte[] keyBytes = Decoders.BASE64.decode(secret);
            return Keys.hmacShaKeyFor(keyBytes);
        } catch (Exception e) {
            log.error("Error resolving JWT signing key. secret length={}", secret.length(), e);
            throw new RuntimeException(
                    "Error resolving JWT signing key. Ensure jwt.secret is valid Base64 "
                            + "and at least 32 bytes after decode (HS256).", e);
        }
    }

    private static String resolveSecret() {
        String fromSystem = System.getProperty("jwt.secret");
        if (fromSystem != null && !fromSystem.isBlank()) {
            return fromSystem.trim();
        }
        if (!conf.hasPath("jwt.secret")) {
            throw new IllegalStateException(
                    "jwt.secret is missing. Set it in env.conf or pass -Djwt.secret=<base64-secret>");
        }
        return conf.getString("jwt.secret").trim();
    }

    private static String resolveTokenValidity() {
        String fromSystem = System.getProperty("jwt.token.validity");
        if (fromSystem != null && !fromSystem.isBlank()) {
            return fromSystem.trim();
        }
        if (!conf.hasPath("jwt.token.validity")) {
            return "259200000"; // 3 days in ms (matches prior hardcoded token window)
        }
        return conf.getString("jwt.token.validity").trim();
    }
}
