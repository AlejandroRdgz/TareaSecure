package models;

import java.util.Date;
import javax.persistence.Entity;
import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author rodrigo
 */
@Entity
public class Usuario extends Model{
    
    @Required
    @MaxSize(value=10 )
    public String usuario;
    @Password
    public String password;
    public String primerApellido;
    public String segundoApellido;
    public String nombre;
    public Date fechaNacimiento;
    @Email
    public String email;
    public Boolean admin;

    @Override
    public String toString() {
        return String.format("%s %s", this.nombre, this.primerApellido);
    }    
       
}
