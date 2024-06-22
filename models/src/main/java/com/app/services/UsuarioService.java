package com.app.services;

import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import com.app.services.interfaces.IUsuarioService;
import com.app.utils.ListUtils;
import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import jakarta.inject.Inject;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class UsuarioService implements IUsuarioService {

    @Inject
    private IUsuarioDao usuarioDao;

    @Override
    public List<UsuarioViewModel> getAll(boolean includeBlocked) {
        return ListUtils.mapList(usuarioDao.getAll(includeBlocked), this::toViewModel);
    }

    @Override
    public UsuarioViewModel create(UsuarioCreateViewModel uvm) {
        Usuario usuario = new Usuario(uvm.getNombre(), uvm.getApellido(), uvm.getUsername(), uvm.getPassword(), uvm.getEmail(), uvm.getRol());
        usuarioDao.save(usuario);
        return toViewModel(usuario);
    }

    @Override
    public UsuarioViewModel update(Long usuarioId, UsuarioCreateViewModel uvm) {
        Usuario usuario = usuarioDao.getById(usuarioId);

        if (uvm.getNombre() != null) usuario.setNombre(uvm.getNombre());
        if (uvm.getApellido() != null) usuario.setApellido(uvm.getApellido());
        if (uvm.getEmail() != null) usuario.setEmail(uvm.getEmail());
        if (uvm.getUsername() != null) usuario.setUsername(uvm.getUsername());
        if (uvm.getPassword() != null) usuario.setPassword(uvm.getPassword());
        if (uvm.getRol() != null) usuario.setRol(uvm.getRol());
        if (uvm.getBlocked() != null) usuario.setBlocked(uvm.getBlocked());

        this.usuarioDao.save(usuario);
        return toViewModel(usuario);
    }

    private UsuarioViewModel toViewModel(Usuario usuario) {
        return new UsuarioViewModel(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getRol(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.isBlocked()
        );
    }
}
