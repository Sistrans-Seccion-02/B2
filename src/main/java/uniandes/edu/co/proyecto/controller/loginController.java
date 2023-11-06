package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;


@Controller
public class loginController {
    /* 
    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String pass, @RequestParam String userType) {
        // Realiza la autenticación y verifica el tipo de usuario aquí
        
        if (usuarioEsValido(user, pass, userType)) {
            switch (userType) {
                case "Cliente":
                    return "redirect:/indexCliente"; // Redirige a la página del cliente
                case "Empleado":
                    return "redirect:/indexEmpleado"; // Redirige a la página del empleado
                // Agrega más casos para otros tipos de usuario si es necesario
                default:
                    return "redirect:/"; // Redirige a la página principal por defecto
            }
        } else {
            return "redirect:/?error=true"; // Redirige de nuevo al formulario con un mensaje de error
        }
    }
   // Implementa aquí tu lógica de autenticación para verificar las credenciales en el servidor
    private boolean usuarioEsValido(String user, String pass, String userType) {
        // Implementa la validación aquí, por ejemplo, consultando una base de datos
        // o utilizando tus propias reglas de autenticación
        // Devuelve true si las credenciales son válidas, false en caso contrario
        // ...
        return  usuarioJSON.usuario === user && usuarioJSON.contraseña === pass && usuarioJSON.tipoDeUsuario === userType;
        ;
    }
 */

    
}
