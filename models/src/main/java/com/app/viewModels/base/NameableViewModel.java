package com.app.viewModels.base;

public class NameableViewModel extends IdentifiableViewModel {

    String nombre;

    public NameableViewModel() {
        super();
    }

    public NameableViewModel(Long id, String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
