/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import OpcionesJuego.Construction;
import OpcionesJuego.Gaming;
import TDAs.ArrayList;
import TDAs.CircleLinkedList;
import TDAs.Direction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author tagoa
 */
public class Interfaz {
    public static Pane PanelJuego(CircleLinkedList<ImageView> personajes){
        Construction cons= new Construction();
       
        Pane pane= cons.AgregarPane(personajes);
        return pane;
    }
    public static StackPane StagePregunta(CircleLinkedList<ImageView> personajes,HBox panel){
        Label lb= new Label("Selecciones los personajes inmortales");
        StackPane stack= new StackPane();
        Button listo= new Button("Listo");
        listo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StackPane st=StageDireccion(personajes);
                CambiarScene(st,panel);
            }
        });
        VBox vb= new VBox(lb,listo);
        vb.setSpacing(20);
        vb.setAlignment(Pos.CENTER);
        lb.setTextFill(Color.web("#EF3123"));
        lb.setFont(new Font("Arial Black",16));
        stack.getChildren().add(vb);
        return stack;
    }
    public static StackPane StageDireccion(CircleLinkedList<ImageView> personajes){
        Label lb= new Label("Selecciones la direccion de la masacre");
        VBox stack= new VBox();
        Button horario= new Button("Horario");
        Button antihorario= new Button("Antihorario");
        //Ingresar acciones a  los botones para comenzar la matanza en la direccion que se elija y desabilitar los botones al seleccionar
        horario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb.setVisible(false);
                Gaming.PoderComenzarMatanza(personajes, Direction.HORARIO);
                horario.setVisible(false);
                antihorario.setVisible(false);
                lb.setText("Selecciones quien comenzara la matanza****");
                lb.setVisible(true);
            }
        }
        );
        antihorario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb.setVisible(false);
                Gaming.PoderComenzarMatanza(personajes, Direction.ANTIHORARIO);
                horario.setVisible(false);
                antihorario.setVisible(false);
                lb.setText("Selecciones quien comenzara la matanza****");
                lb.setVisible(true);
                Construction.EliminarMuertos(personajes);
            }
        }
        );
        lb.setTextFill(Color.web("#EF3123"));
        lb.setFont(new Font("Arial Black",16));
        stack.getChildren().addAll(lb,horario,antihorario);
        stack.setSpacing(10);
        stack.setAlignment(Pos.CENTER);
        StackPane st= new StackPane(stack);
        return st;
    }
    public static Stage StageTotal(StackPane pregunta,Pane juego){
        Stage stage= new Stage();
        HBox hb= new HBox(juego,pregunta);
        hb.setSpacing(40);
        Scene scene= new Scene(hb,2000,1000);
        stage.setScene(scene);
        stage.setTitle("Juego");
        return stage;
    }
    public static void CambiarScene(StackPane cambio,HBox panel){
        panel.getChildren().set(1, cambio);
    }
    public void PanelJuego(int Nperson){
            Construction cons= new Construction();
         cons.AudioFondo();
        CircleLinkedList<ImageView> personajes=cons.CrearCirculoMuerteLista(Nperson);
        HBox hb= new HBox();
        Pane pane=Interfaz.PanelJuego(personajes);
        cons.PoderSerInmortales(personajes);
        StackPane st= Interfaz.StagePregunta(personajes,hb);
        Stage stage= new Stage();
        hb.getChildren().addAll(pane,st);
        hb.setSpacing(40);
        
        Scene scene= new Scene(hb,2000,1000);
        stage.setScene(scene);
        stage.setTitle("Juego");
        stage.show();
        }
    public void Principal(){
        Stage stage= new Stage();
        GridPane grid= new GridPane();
        Label nombre= new Label("Usuario: ");
        //#F00F29
        nombre.setTextFill(Color.web("#F00F29"));
        nombre.setFont(new Font("Arial Black",18));
        TextField tfnombre= new TextField();
        Label contra= new Label("Contraseña");
        
        contra.setTextFill(Color.web("#F00F29"));
        contra.setFont(new Font("Arial Black",18));
        StackPane st= new StackPane();
        TextField tfcontra= new TextField();
        grid.add(nombre, 0, 0);
        grid.add(tfnombre, 1, 0);
        grid.add(contra, 0, 1);
        grid.add(tfcontra, 1, 1);
        Button ingresar= new Button("Ingresar");
        Button registrar= new Button("Registrar");
        ingresar.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-padding: 20px 25px;-fx-background-color: #5C99BA");
        ingresar.setTextFill(Color.web("#ffffff"));
        registrar.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-padding: 20px 25px;-fx-background-color: #5C99BA");
        registrar.setTextFill(Color.web("#ffffff"));
        
        Label mensaje= new Label("");
        mensaje.setTextFill(Color.web("#7943E3"));
        mensaje.setFont(new Font("Arial Black",18));
        VBox vb= new VBox();
        vb.getChildren().addAll(grid,ingresar,registrar,mensaje);
        vb.setSpacing(20);
        vb.setAlignment(Pos.CENTER);
        Image img= new Image("/Recursos/fondo.jpg");
        ImageView img1= new ImageView(img);
        img1.setFitHeight(506);
        img1.setFitWidth(900);
        st.getChildren().addAll(img1,vb);
        ingresar.setOnAction(new EventHandler<ActionEvent>(){
          @Override
                public void handle(ActionEvent event) {
                    mensaje.setVisible(false);
                    if(tfnombre.getText().equals("") || tfcontra.getText().equals("")){
                        mensaje.setText("No a ingresado todos los campos***");
                        mensaje.setVisible(true);
                    }
                    else{
                        boolean bo=Usuario.ComprobarExistencia(tfnombre.getText());
                        if(bo){
                        stage.close();
                        ArrayList<Usuario> users= Usuario.Deserializar("usuarios.txt");
                        users.addLast(new Usuario(tfnombre.getText(),tfcontra.getText()));
                        Usuario.Serializar("usuarios.txt", users);
                        PanelNumero();
                        }
                        else{
                            mensaje.setText("Este usuario no existe, registrese");
                        mensaje.setVisible(true);
                        }
                    }
                }  
        }
        );
        registrar.setOnAction(new EventHandler<ActionEvent>(){
          @Override
                public void handle(ActionEvent event) {
                    mensaje.setVisible(false);
                    if(tfnombre.getText().equals("") || tfcontra.getText().equals("")){
                        mensaje.setText("No a ingresado todos los campos***");
                        mensaje.setVisible(true);
                    }
                    else{
                        boolean bo=Usuario.ComprobarExistencia(tfnombre.getText());
                        if(!bo){
                        stage.close();
                        PanelNumero();
                        }
                        else{
                            mensaje.setText("Este usuario nya existe, ingrese ");
                        mensaje.setVisible(true);
                        }
                    }
                }  
        }
        );
        Scene scene= new Scene(st,900,506);
       
        stage.setScene(scene);
        stage.setTitle("Bienveni@");
        stage.show();
        
    }
    public void PanelNumero(){
        Stage stage= new Stage();
        VBox vb= new VBox();
        Label lb= new Label("Ingrese numero de personajes");
        TextField tf= new TextField();
        Button bt= new Button("Confirmar");
        Label mensaje= new Label("");
        vb.getChildren().addAll(lb,tf,bt,mensaje);
        bt.setOnAction(new EventHandler<ActionEvent>(){
          @Override
                public void handle(ActionEvent event) {
                    mensaje.setVisible(false);
                    if(tf.getText().equals("")){
                        mensaje.setText("No a ingresado todos los campos***");
                        mensaje.setVisible(true);
                    }
                    
                    else{
                        try{
                            int numero=Integer.parseInt(tf.getText());
                            if(numero>0 && numero<20){
                                stage.close();
                                PanelJuego(numero);
                                
                            }
                            else{
                                mensaje.setText("Solo se pueden ingresar numeros del 1 al 20");
                        mensaje.setVisible(true);
                            }
                        }
                        catch(Exception e){
                            mensaje.setText("Lo que ingreso no es un numero");
                            mensaje.setVisible(true);
                        }
                    }
                }  
        }
        );
        Scene scene= new Scene(vb,400,400);
        stage.setScene(scene);
        stage.setTitle("Aiudaaaa");
        stage.show();
    }
    
}
