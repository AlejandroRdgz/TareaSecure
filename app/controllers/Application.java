package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import org.hibernate.annotations.Check;


@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        
        String usuario = Security.connected();
        render(usuario);
    }
    
    public static void login() {
        System.out.println("Todos los usuarios");
        List<Usuario> usuarios = Usuario.findAll();
        
        for (Usuario usuario : usuarios) {
            System.out.println("Usuario = "+usuario);
            
        }
        
        
        System.out.println("Todos lo usuarios con apellido Corona");
        
        List<Usuario> usuariosCorona = Usuario.find("primerApellido","Corona")
                .fetch();
        
        for (Usuario usuarioCorona : usuariosCorona) {
            System.out.println("Usuario Corona: "+ usuarioCorona);
        }
        
        
        
        
        render();
    }
    
    //@Check("administrador")
    public static void autenticar(String usuario, String password){
        session.put("usuario", usuario);
        index();
    }

}