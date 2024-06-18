package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Administrador;
import com.app.models.Usuario;
import com.app.services.interfaces.IUsuarioService;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.Arrays;
import java.util.List;

@Service
@PerLookup
public class UsuarioService implements IUsuarioService {


    private IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();

    public List<Usuario> getAll(){
        return usuarioDao.getAll();
    }
}
