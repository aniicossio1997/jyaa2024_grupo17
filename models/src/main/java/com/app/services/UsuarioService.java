package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IUsuarioDao;
import com.app.models.Administrador;
import com.app.models.EncargadoDeSala;
import com.app.models.Usuario;
import com.app.models.enums.RolUsuario;
import com.app.services.interfaces.IUsuarioService;
import com.app.utils.ListUtils;
import com.app.viewModels.UsuarioCreateViewModel;
import com.app.viewModels.UsuarioViewModel;
import jakarta.validation.ConstraintViolation;
import org.glassfish.hk2.api.PerLookup;
import org.hibernate.exception.ConstraintViolationException;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class UsuarioService implements IUsuarioService {

    private IUsuarioDao usuarioDao = FactoryDAO.createUsuarioDao();

    @Override
    public List<UsuarioViewModel> getAll() {
        return ListUtils.mapList(usuarioDao.getAll(), this::toViewModel);
    }

    @Override
    public UsuarioViewModel create(UsuarioCreateViewModel uvm) {
        Usuario usuario;
        if (uvm.getRol() == RolUsuario.ADMIN) {
            usuario = new Administrador(uvm.getNombre(), uvm.getApellido(), uvm.getUsername(), uvm.getPassword(), uvm.getEmail());
        } else {
            usuario = new EncargadoDeSala(uvm.getNombre(), uvm.getApellido(), uvm.getUsername(), uvm.getPassword(), uvm.getEmail());
        }

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

        if (uvm.getRol() != null && (uvm.getRol() != usuario.getRol())) {
            this.usuarioDao.updateRol(usuario, uvm.getRol());
        }

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
                usuario.getEmail()
        );
    }
}
