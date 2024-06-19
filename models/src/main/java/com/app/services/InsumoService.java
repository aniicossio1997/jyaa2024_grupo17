package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IInsumoDao;

import com.app.models.Insumo;
import com.app.services.interfaces.IInsumoService;
import com.app.utils.ListUtils;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class InsumoService  implements IInsumoService {
    private IInsumoDao insumoDao= FactoryDAO.createInsumoDao();
    @Override
    public List<NameableViewModel> getAll() {
        return  ListUtils.mapList(insumoDao.getAll(), this::toViewModel);
    }

    @Override
    public RecursoPostViewModel create(RecursoPostViewModel materiaPrima) {
        return null;
    }
    private NameableViewModel toViewModel(Insumo insumo) {
        return new NameableViewModel(
                insumo.getId(),
                insumo.getNombre()

        );
    }
}
