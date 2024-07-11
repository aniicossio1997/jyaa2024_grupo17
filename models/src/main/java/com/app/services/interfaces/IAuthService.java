package com.app.services.interfaces;

import com.app.viewModels.AuthViewModel;
import com.app.viewModels.LoginRequestViewModel;
import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import io.jsonwebtoken.Claims;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
import java.util.Optional;

@Contract
public interface IAuthService {

    AuthViewModel login(LoginRequestViewModel data);

}
