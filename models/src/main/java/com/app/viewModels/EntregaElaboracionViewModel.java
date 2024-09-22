package com.app.viewModels;


import com.app.viewModels.base.IdentifiableViewModel;

import java.util.Date;

public class EntregaElaboracionViewModel extends IdentifiableViewModel {

    public long cantidad;
    public ElaboracionViewModel elaboracion;
    public PuntoVentaViewModel puntoVenta;
    public Date fecha;
    public UsuarioViewModel autor;

    public EntregaElaboracionViewModel(long cantidad, ElaboracionViewModel elaboracion, Date fecha, PuntoVentaViewModel puntoVenta) {
        this.cantidad = cantidad;
        this.elaboracion = elaboracion;
        this.fecha = fecha;
        this.puntoVenta = puntoVenta;
    }

    public EntregaElaboracionViewModel(Long id, long cantidad, ElaboracionViewModel elaboracion, Date fecha, PuntoVentaViewModel puntoVenta, UsuarioViewModel autor) {
        super(id);
        this.cantidad = cantidad;
        this.elaboracion = elaboracion;
        this.fecha = fecha;
        this.puntoVenta = puntoVenta;
        this.autor = autor;
    }
}

