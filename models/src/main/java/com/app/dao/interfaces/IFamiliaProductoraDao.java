package com.app.dao.interfaces;

import java.util.List;

import com.app.models.FamiliaProductora;

public interface IFamiliaProductoraDao {

    void save(FamiliaProductora item);

    FamiliaProductora getById(Long id);
    
    List<FamiliaProductora> getAll();


   /* void delete(Long id); */
    
}
