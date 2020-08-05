/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionPrincipal;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author claud
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button productos;
    @FXML
    private Button tipos;
    @FXML
    private Button riego;
    @FXML
    private Button almanaque;
    
    @FXML
    public void seccionProductos(ActionEvent event) throws IOException{
        Parent prodView = FXMLLoader.load(getClass().getResource("/PackageProducto/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(prodViewScene);
        window.setTitle("Productos");
        window.show();
    }
    
    @FXML
    public void seccionTipos(ActionEvent event) throws IOException{
        Parent prodView = FXMLLoader.load(getClass().getResource("/PackageTipos/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(prodViewScene);
        window.setTitle("Tipos");
        window.show();
    }
    @FXML
    public void seccionAlmanaque(ActionEvent event) throws IOException{
        Parent prodView = FXMLLoader.load(getClass().getResource("/PackageAlmanaque/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(prodViewScene);
        window.setTitle("Almanaque");
        window.show();
    }
    @FXML
    public void seccionRiego(ActionEvent event) throws IOException{
        Parent prodView = FXMLLoader.load(getClass().getResource("/PackageRiego/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(prodViewScene);
        window.setTitle("Riego");
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}
