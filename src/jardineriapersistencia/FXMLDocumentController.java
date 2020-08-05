/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardineriapersistencia;

import Connector.Connector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author claud
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea resultados;
    @FXML
    private Button MySQL;
    @FXML
    private Button SQL;
    @FXML
    private Button iniciar;
    @FXML
    private TextField cajaUsuario;
    @FXML
    private PasswordField cajaPassword;
    private final String strUser = "root";
    private final String strPwd = "root";
    private boolean MySQLIngresado = false;
    private boolean SQLServerIngresado = false;
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    @FXML
    public void conexcionMySQL(ActionEvent event) {
        String filename = "MySQLHibernate.cfg.xml";
        System.err.println("Iniciando");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion.");
            configuration.configure(filename);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SessionFactory conexcion = configuration.buildSessionFactory(serviceRegistry);
            factory = conexcion;
            Connector.setConeccionActual(conexcion);
        } catch (HibernateException ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
        MySQLIngresado = true;
        MySQL.setDisable(true);
    }

    @FXML
    public void conexcionSQLServer(ActionEvent event) {
        String filename = "SQLHibernate.cfg.xml";
        System.err.println("Iniciando");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion.");
            configuration.configure(filename);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SessionFactory conexcion = configuration.buildSessionFactory(serviceRegistry);
            factory = conexcion;
            Connector.setConeccionActual(conexcion);
        } catch (HibernateException ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
        SQLServerIngresado = true;
        SQL.setDisable(true);
    }

    @FXML
    public void iniciarPrograma(ActionEvent event) throws IOException {
        String usuario = cajaUsuario.getText();
        String password = cajaPassword.getText();
        if (usuario.equals(strUser) && password.equals(strPwd)) {
            if (MySQLIngresado == true) {
                Connector.getConectionActual();
            } else if (SQLServerIngresado == true) {
                Connector.getConectionActual();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ADVERTENCIA DE USO | Login");
                alert.setHeaderText("ERROR:  Coneccion");
                alert.setContentText("Seleccione una opcion");
                alert.showAndWait();
            }
            if (Connector.getConectionActual() != null) {
                System.out.println("Iniciando programa...");
                Parent prodView;
                prodView = FXMLLoader.load(getClass().getResource("/aplicacionPrincipal/FXMLDocument.fxml"));
                Scene prodViewScene = new Scene(prodView);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(prodViewScene);
                window.setTitle("index");
                window.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ADVERTENCIA DE USO | Login");
            alert.setHeaderText("ERROR:  Sesion");
            alert.setContentText("Usuario o contrase�a invalida");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
