/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageProducto;

import Connector.Connector;
import Daos.DAOProducto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

/**
 * FXML Controller class
 *
 * @author claud
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Person> table;
    @FXML
    private Button agregar;

    @FXML
    private Button generar;

    @FXML
    private DatePicker cajaCalendario;

    @FXML
    private TableColumn<?, ?> columna1;

    @FXML
    private TableColumn<?, ?> columna2;

    @FXML
    private TableColumn<?, ?> columna3;

    @FXML
    private TableColumn<?, ?> columna4;

    @FXML
    private TextField cajaId;

    @FXML
    private TextField cajaPlanta;

    @FXML
    private TextField cajaCalidad;

    @FXML
    private Button modificar;

    @FXML
    private Button eliminar;
    @FXML
    private LineChart<String, Integer> chartBarras;
    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> leyenda;

    @FXML
    public void paginaRegreso(ActionEvent event) throws IOException {
        Parent prodView = FXMLLoader.load(getClass().getResource("/aplicacionPrincipal/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(prodViewScene);
        window.setTitle("Menu Principal");
        window.show();
    }

    @FXML
    public void paginaRecarga(ActionEvent event) throws IOException {
        Parent prodView = FXMLLoader.load(getClass().getResource("/PackageProducto/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(prodViewScene);
        window.setTitle("productos");
        window.show();
    }

    @FXML
    public void accionAgregar(ActionEvent event) throws SQLException {
        System.out.println(cajaCalendario.getValue().toString());
        DAOProducto i = new DAOProducto();
        i.addProducto(cajaPlanta.getText(), cajaCalendario.getValue().toString(), cajaCalidad.getText());
        showBooks();
    }

    @FXML
    public void accionEliminar(ActionEvent event) throws SQLException {
        DAOProducto i = new DAOProducto();
        i.deleteAlumno(Integer.valueOf(cajaId.getText()));
        showBooks();
    }

    @FXML
    public void accionEditar(ActionEvent event) throws SQLException {
        DAOProducto i = new DAOProducto();
        i.updateAll(Integer.valueOf(cajaId.getText()), cajaCalendario.getValue().toString(), cajaPlanta.getText(), cajaCalidad.getText());
        showBooks();
    }

    @FXML
    private void btnGenera(ActionEvent event) throws Exception {
        ObservableList<Person> ts = FXCollections.observableArrayList();
        DAOProducto i = new DAOProducto();
        ts = i.traergrafica();
        XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<>();
        ObservableList<String> leyenda = FXCollections.observableArrayList();
        for (int a = 0; a < ts.size(); a++) {
            Person op = ts.get(a);
            leyenda.add("" + op.getPrimerNombre());
            dataSeries1.getData().add(new XYChart.Data<>("" + op.getPrimerNombre(), ts.size())); // posicion 1 es la
            xAxis.setCategories(leyenda);
        }
        dataSeries1.setName("Cantidad por Producto");
        chartBarras.getData().add(dataSeries1);
    }

    public void showBooks() {
        DAOProducto i = new DAOProducto();
        ObservableList a = i.traerlistProductos();
        table.getItems().setAll(a);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooks();
    }

    public static class Person {

        private final SimpleStringProperty primerNombre;
        private final SimpleStringProperty segundoNombre;
        private final SimpleStringProperty email;
        private final SimpleStringProperty cuarto;

        private Person(String fName, String lName, String emailq, String cua) {

            this.primerNombre = new SimpleStringProperty(fName);
            this.segundoNombre = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(emailq);
            this.cuarto = new SimpleStringProperty(cua);
        }

        public String getPrimerNombre() {
            return primerNombre.get();
        }

        public void setPrimerNombre(String fName) {
            primerNombre.set(fName);
        }

        public void setCuarto(String fName) {
            cuarto.set(fName);
        }

        public String getCuarto() {
            return cuarto.get();
        }

        public String getSegundoNombre() {
            return segundoNombre.get();
        }

        public void setSegundoNombre(String lName) {
            segundoNombre.set(lName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String emailq) {
            email.set(emailq);
        }
    }

}
