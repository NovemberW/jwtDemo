package de.axitera.jwt.controller;

import de.axitera.jwt.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger((AuthController.class));

    private final TokenService ts;

    public AuthController(TokenService ts) {
        this.ts = ts;
    }

    @PostMapping("token")
    public String token(Authentication authentication){
        LOG.debug("Token fpr user : '{}'",authentication.getName());
        String token = ts.generateToken(authentication);
        LOG.debug("Token granted '{}'",token);
        return token;
    }
}
