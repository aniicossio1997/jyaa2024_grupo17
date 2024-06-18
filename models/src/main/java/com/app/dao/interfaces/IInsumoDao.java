package com.app.dao.interfaces;

import com.app.models.FamiliaProductora;
import com.app.models.Insumo;

import java.util.List;

public interface IInsumoDao {
    void save(Insumo item);

    Insumo getById(Long id);

    List<Insumo> getAll();
}
