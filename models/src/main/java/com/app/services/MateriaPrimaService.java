package com.app.services;

import com.app.dao.FactoryDAO;
import com.app.dao.interfaces.IMateriaPrimaDao;
import com.app.models.MateriaPrima;
import com.app.services.interfaces.IMateriaPrimaService;
import com.app.utils.ListUtils;
import com.app.viewModels.RecursoPostViewModel;
import com.app.viewModels.base.NameableViewModel;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@PerLookup
public class MateriaPrimaService  implements IMateriaPrimaService {
    private IMateriaPrimaDao materiaPrimaDao= FactoryDAO.createMateriaPrimaDao();

    @Override
    public List<NameableViewModel> getAll() {
        return  ListUtils.mapList(materiaPrimaDao.getAll(), this::toViewModel);
    }

    @Override
    public RecursoPostViewModel create(RecursoPostViewModel materiaPrima) {
        return null;
    }

    private NameableViewModel toViewModel(MateriaPrima materiaPrima) {
        return new NameableViewModel(
                materiaPrima.getId(),
                materiaPrima.getNombre()

        );
    }
}
