/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.models;

import exemploconexion.models.Vehicle;

/**
 *
 * @author maggiemendez
 */
public class Driver {
    private Vehicle unidadAsignada;
    private int idEmpleado;
    private boolean disponibilidad;

    /**
     * @return the unidadAsignada
     */
    public Vehicle getUnidadAsignada() {
        return unidadAsignada;
    }

    /**
     * @param unidadAsignada the unidadAsignada to set
     * @return 
     */
    public void setUnidadAsignada(Vehicle unidadAsignada) {
        this.unidadAsignada = unidadAsignada;
    }

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the disponibilidad
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     * @param disponibilidad the disponibilidad to set
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
