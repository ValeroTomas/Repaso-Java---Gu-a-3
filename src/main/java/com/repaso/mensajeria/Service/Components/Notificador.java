package com.repaso.mensajeria.Service.Components;

import com.repaso.mensajeria.Service.IMensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notificador {

    private final IMensajeServicio mensajeServicio;

    @Autowired
    public Notificador(IMensajeServicio mensajeServicio) {
        this.mensajeServicio = mensajeServicio;
    }

    public void notificar(String mensaje) {
        mensajeServicio.enviarMensaje(mensaje);
    }
}
