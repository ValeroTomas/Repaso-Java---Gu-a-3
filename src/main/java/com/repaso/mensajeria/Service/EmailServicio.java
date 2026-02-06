package com.repaso.mensajeria.Service;

import com.repaso.mensajeria.Service.Interface.IMensajeServicio;
import org.springframework.stereotype.Service;

@Service
public class EmailServicio implements IMensajeServicio {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Enviando mensaje por email: " + mensaje);
    }
}
