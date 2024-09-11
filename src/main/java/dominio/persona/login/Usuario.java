package dominio.persona.login;
import dominio.persona.verificadorContrasenias.Requisitos;
import dominio.persona.verificadorContrasenias.VerificadorContrasenia;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Usuario")
@Data
public class Usuario extends VerificadorContrasenia {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nombreUsuario", columnDefinition = "VARCHAR(50)")
    private String nombreUsuario;

    @Column(name = "contraseñaUsuario", columnDefinition = "VARCHAR(50)")
    private String contrasena;
    //private Colaborador colaborador;
    @ManyToMany
    @JoinTable(name = "usuario_Rol",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private Rol rol;

    public void crearUsuario(String contrasena, String usuario , ArrayList<Requisitos> requi){
        this.iniciarRequisitos(requi);
        this.nombreUsuario = usuario;
        if(validarContrasena(contrasena)){
            this.contrasena=contrasena;}
        } //else ingrese otra contrasena
}
