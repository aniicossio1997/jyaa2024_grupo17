package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Usuario;
import com.app.services.interfaces.IUsuarioService;
import com.app.utils.ListUtils;
import com.app.viewModels.UsuarioPostViewModel;
import com.app.viewModels.UsuarioViewModel;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class UsuarioService implements IUsuarioService {

    private IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();

    public List<UsuarioViewModel> getAll() {
        return ListUtils.mapList(usuarioDao.getAll(), this::toViewModel);
    }

    @Override
    public UsuarioViewModel create(UsuarioPostViewModel usuario) {
        return null;
    }

    private UsuarioViewModel toViewModel(Usuario usuario) {
        return new UsuarioViewModel(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getRol(),
                usuario.getUsername(),
                usuario.getEmail()
        );
    }
}