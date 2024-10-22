package ar.edu.utn.frba.dds.server;

import ar.edu.utn.frba.dds.controllers.*;
import io.javalin.Javalin;

public class Router {
    public static void init(Javalin app) {
        // Pantalla principal y login
        //app.get("/", ServiceLocator.instanceOf(LandingPageController.class)::index);
        app.get("/", ((LandingPageController) FactoryController.controller("LandingPage"))::index);
        app.get("/mapa", ((LandingPageController) FactoryController.controller("LandingPage"))::index);
        app.get("/nosotros", ((LandingPageController) FactoryController.controller("LandingPage"))::indexNosotros);

        app.get("/login", ((LoginController) FactoryController.controller("Login"))::index);
        app.post("/login", ((LoginController) FactoryController.controller("Login"))::update);
        app.get("/logout", ((LoginController) FactoryController.controller("Login"))::logout);

        // Registro de personas
        app.get("/registro", ((RegistroUsuariosController) FactoryController.controller("Registro"))::elegirTipo);
        app.get("/registro/juridica", ((RegistroUsuariosController) FactoryController.controller("Registro"))::formularioJuridica);
        app.get("/registro/humana", ((RegistroUsuariosController) FactoryController.controller("Registro"))::formularioHumana);
        app.post("/registro/juridica", ((RegistroUsuariosController) FactoryController.controller("Registro"))::registrarJuridica);
        app.post("/registro/humana", ((RegistroUsuariosController) FactoryController.controller("Registro"))::registrarHumana);
        app.get("/check-username", ((RegistroUsuariosController) FactoryController.controller("Registro"))::checkUsername);
        app.get("/registro/vulnerable", ((RegistroVulnerableController) FactoryController.controller("Vulnerables"))::indexRegistroVulnerable);
        app.post("/registro/vulnerable", ((RegistroVulnerableController) FactoryController.controller("Vulnerables"))::registroVulnerable);

        app.get("/cargamasiva", ((CargaMasivaController) FactoryController.controller("CargaMasiva"))::index);
        app.post("/cargar-csv", ((CargaMasivaController) FactoryController.controller("CargaMasiva"))::cargarCSV);

        app.get("/colaboraciones", ((ColaboracionController) FactoryController.controller("Colaboracion"))::index);
        app.get("/colaboraciones/nueva", ((ColaboracionController) FactoryController.controller("Colaboracion"))::indexNueva);
        app.get("/colaboraciones/historico", ((ColaboracionController) FactoryController.controller("Colaboracion"))::indexHistorico);
        app.post("/colaboraciones/dinero", ((ColaboracionController) FactoryController.controller("Colaboracion"))::ColaboracionDinero);
        app.post("/colaboraciones/vianda", ((ColaboracionController) FactoryController.controller("Colaboracion"))::ColaboracionVianda);
        app.post("/colaboraciones/distribucion", ((ColaboracionController) FactoryController.controller("Colaboracion"))::ColaboracionDistribucion);
        app.get("/colaboraciones/heladera", ((ColaboracionController) FactoryController.controller("Colaboracion"))::ColaboracionHeladera);

        app.get("/heladeras", ((HeladerasController) FactoryController.controller("Heladeras"))::index);
        app.get("/heladeras/{id}", ((HeladerasController) FactoryController.controller("Heladeras"))::indexInd);
        app.get("/heladeras/{id}/incidente", ((HeladerasController) FactoryController.controller("Heladeras"))::indexFalla);
        app.post("/heladeras/{id}/incidente", ((HeladerasController) FactoryController.controller("Heladeras"))::formularioIncidente);

        // Lógica de usuarios (CRUD)
        app.get("/perfil", ((UsuariosController) FactoryController.controller("Usuarios"))::indexPerfil);
        app.get("/editar/humana", ((UsuariosController) FactoryController.controller("Usuarios"))::indexEditHumana);
        app.post("/editar/humana",((UsuariosController) FactoryController.controller("Usuarios"))::editHumana);
        app.get("/editar/juridica", ((UsuariosController) FactoryController.controller("Usuarios"))::indexEditJuridica);
        app.post("/editar/juridica",((UsuariosController) FactoryController.controller("Usuarios"))::editJuridica);



        app.get("/usuarios", ((UsuariosController) FactoryController.controller("Usuarios"))::index);
        app.post("/usuarios/crear", ((UsuariosController) FactoryController.controller("Usuarios"))::create);
        app.get("/usuarios/{id}/eliminar", ((UsuariosController) FactoryController.controller("Usuarios"))::delete);
        app.get("/usuarios/{id}", ((UsuariosController) FactoryController.controller("Usuarios"))::show);
        app.post("/usuarios/{id}/editar", ((UsuariosController) FactoryController.controller("Usuarios"))::edit);

        //Puntos y canje de premios
        app.get("/puntos-y-premios", ((PremiosController) FactoryController.controller("Premios"))::index);

        //Reportes
        app.get("/reportes/fallos_heladera", ((FallosHeladeraController) FactoryController.controller("FallosHeladera"))::index);
    }
}
