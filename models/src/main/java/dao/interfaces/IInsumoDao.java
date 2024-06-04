package dao.interfaces;

import grupo17.FamiliaProductora;
import grupo17.Insumo;

import java.util.List;

public interface IInsumoDao {
    void save(Insumo item);

    Insumo getById(Long id);

    List<Insumo> getAll();
}
