package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {
    List<Liquidacion> listarLiquidaciones();
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    Liquidacion buscarLiquidacionId(long idLiquidacion);
    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, long idLiquidacion);
    public void eliminarliquidacion(long idLiquidacion);
}
