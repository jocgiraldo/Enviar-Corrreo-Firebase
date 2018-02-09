package co.hitcompany.enviarcorreofirebase;

/**
 * Created by Pc on 08/02/2018.
 */

public class Correo {
    private String correo;
    private String asunto;
    private String mensaje;

    public Correo() {
    }

    public Correo(String correo, String asunto, String mensaje) {
        this.correo = correo;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
