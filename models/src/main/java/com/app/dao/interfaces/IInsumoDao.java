package com.app.dao.interfaces;

import com.app.models.FamiliaProductora;
import com.app.models.Insumo;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;
@Contract
public interface IInsumoDao {
    void save(Insumo item);

    Insumo getById(Long id);

    List<Insumo> getAll();
}
