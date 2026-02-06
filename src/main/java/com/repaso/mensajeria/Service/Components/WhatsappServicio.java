package com.repaso.mensajeria.Service.Components;

import com.repaso.mensajeria.Service.IMensajeServicio;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class WhatsappServicio implements IMensajeServicio {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Enviando mensaje por whatsapp: " + mensaje);
    }
}
