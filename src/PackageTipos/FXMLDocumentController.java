/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageTipos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Connector.Connector;
import Daos.DAOProducto;
import Daos.DAOTipos;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    @FXML
    private Button generarReporte;
    @FXML
    private Button botonRegreso;
    @FXML
    private Button botonRecarga;
    @FXML
    private TextField campoIdPlanta;
    @FXML
    private TextField campoIdTipo;
    @FXML
    private TextField campoTipoPlanta;
    @FXML
    private TextArea campoDescripcion;
    @FXML
    private BarChart<String, Integer> chartBarras;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private TableView<Person> table;
    @FXML
    private TableColumn<?, ?> idPlanta;
    @FXML
    private TableColumn<?, ?> idTipo;
    @FXML
    private TableColumn<?, ?> tipo;
    @FXML
    private TableColumn<?, ?> descripcion;

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
        Parent prodView = FXMLLoader.load(getClass().getResource("/PackageTipos/FXMLDocument.fxml"));
        Scene prodViewScene = new Scene(prodView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(prodViewScene);
        window.setTitle("Tipos");
        window.show();
    }

    @FXML
    public void accionAgregar(ActionEvent event) throws SQLException {
        System.out.println(campoDescripcion.toString());
        DAOTipos i = new DAOTipos();
        i.addTipo(Integer.valueOf(campoIdTipo.getText()), campoTipoPlanta.getText(), campoDescripcion.getText());
        showBooks();
    }

    @FXML
    public void accionEliminar(ActionEvent event) throws SQLException {
        DAOTipos i = new DAOTipos();
        i.deleteTipo(Integer.valueOf(campoIdTipo.getText()));
        showBooks();
    }

    @FXML
    public void accionEditar(ActionEvent event) throws SQLException {
        DAOTipos i = new DAOTipos();
        i.updateAll(Integer.valueOf(campoIdTipo.getText()), campoTipoPlanta.getText(), campoDescripcion.getText());
        showBooks();
    }

    public void showBooks() {
        DAOTipos i = new DAOTipos();
        ObservableList a = i.traerlistTipos();
        table.getItems().setAll(a);
    }

    @FXML
    private void btnGenera(ActionEvent event) throws Exception {
        ObservableList<PackageTipos.FXMLDocumentController.Person> ts = FXCollections.observableArrayList();
        DAOTipos i = new DAOTipos();
        ts = i.traergrafica();
        XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<>();
        ObservableList<String> leyenda = FXCollections.observableArrayList();
        for (int a = 0; a < ts.size(); a++) {
            PackageTipos.FXMLDocumentController.Person op = ts.get(a);
            leyenda.add("" + op.getPrimerNombre());
            dataSeries1.getData().add(new XYChart.Data<>("" + op.getPrimerNombre(), ts.size())); // posicion 1 es la
            xAxis.setCategories(leyenda);
        }
        dataSeries1.setName("Cantidad por Tipos");
        chartBarras.getData().add(dataSeries1);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
