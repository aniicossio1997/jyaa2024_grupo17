package com.app.viewModels.base;

public class IdentifiableViewModel {
    Long id;

    public IdentifiableViewModel() {
        super();
    }

    public IdentifiableViewModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
