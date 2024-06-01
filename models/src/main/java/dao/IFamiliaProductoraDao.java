package dao;

import java.util.List;

import grupo17.FamiliaProductora;

public interface IFamiliaProductoraDao {

    void save(FamiliaProductora item);

    FamiliaProductora getById(Long id);
    
    List<FamiliaProductora> getAll();

   /* void delete(Long id); */
    
}
