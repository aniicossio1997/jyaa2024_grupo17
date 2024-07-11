package com.app.services;

import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Usuario;
import com.app.services.interfaces.IAuthService;
import com.app.services.interfaces.IUsuarioService;
import com.app.utils.ListUtils;
import com.app.viewModels.AuthViewModel;
import com.app.viewModels.LoginRequestViewModel;
import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotAuthorizedException;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

@Service
@PerLookup
public class AuthService implements IAuthService {

    private static final String SECRET_KEY = "bxFWUhRb2aDXzTcACTLpiPTT04UnZ8YUUe04WvtwCqVHPmB42EdfBu1Sckk24A1PtnpSAdJuVJN9bqKbR2y0XJWqqftTA5pEuvhzWzNP6zENwZWyzQqdViJkR2g9FTChz0";
    public static final SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    private final long EXPIRATION_TIME = 172800000; // 2 días en milisegundos

    @Inject
    private IUsuarioDao usuarioDao;

    @Inject
    private MappingService mappingService;

    @Override
    public AuthViewModel login(LoginRequestViewModel data) {
        Optional<Usuario> optUsuario = usuarioDao.getByUsername(data.username, false);
        if (optUsuario.isEmpty() || !Objects.equals(optUsuario.get().getPassword(), data.password)) {
            throw new BadRequestException("invalid_credentials");
        }
        Usuario usuario = optUsuario.get();
        String token = generateToken(usuario.getUsername());
        return new AuthViewModel(token, mappingService.toViewModel(usuario));
    }


    private String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }


}
