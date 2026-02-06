package com.repaso.mensajeria.Service;

import com.repaso.mensajeria.Service.Interface.IMensajeServicio;
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
