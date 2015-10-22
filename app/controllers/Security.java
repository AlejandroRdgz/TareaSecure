/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Usuario;

/**
 *
 * @author alejandro
 */
public class Security extends Secure.Security{
    
    static boolean authenticate (String username, String password){
        Usuario usuario = Usuario.find("usuario", username).first();
        return usuario != null && usuario.password.equals(password);
    }
    
     static boolean check(String profile){
         Usuario usuario = Usuario.find("usuario", connected()).first();
         if("administrador".equals(profile)){
             return usuario.admin;
         }
         else{
             return false;
         }
             
     }
}
