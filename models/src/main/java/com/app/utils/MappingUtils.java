package com.app.utils;

import com.app.models.baseEntity.NameableBaseEntity;
import com.app.viewModels.base.NameableViewModel;

public class MappingUtils {
    public  static NameableViewModel toViewModel(NameableBaseEntity nameableBaseEntity){
        return new NameableViewModel(nameableBaseEntity.getId(),nameableBaseEntity.getNombre());
    }
}
