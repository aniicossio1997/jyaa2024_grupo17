package com.app.services.interfaces;

import com.app.models.FamiliaProductora;
import com.app.viewModels.FamiliaProductoraPostViewModel;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IFamiliaProductoraService {
    List<FamiliaProductora> getByFilter();
    FamiliaProductora save(FamiliaProductoraPostViewModel entityToAdd);
    FamiliaProductora update(Long id,FamiliaProductoraPostViewModel entityToEdit);
    FamiliaProductora delete();
}
