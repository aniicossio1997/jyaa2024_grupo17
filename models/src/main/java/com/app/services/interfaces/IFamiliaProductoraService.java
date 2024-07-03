package com.app.services.interfaces;

import com.app.models.FamiliaProductora;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import com.app.viewModels.FamiliaProductoraViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IFamiliaProductoraService {
    List<FamiliaProductoraViewModel> getByFilter();
    FamiliaProductora save(FamiliaProductoraPostViewModel entityToAdd);
    FamiliaProductora update(Long id,FamiliaProductoraPostViewModel entityToEdit);
    void delete(Long id);
    FamiliaProductora getById(Long id);
}
