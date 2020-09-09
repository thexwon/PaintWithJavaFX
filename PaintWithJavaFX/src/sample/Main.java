package sample;

import javafx.application.Application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;


import java.util.ArrayList;

public class Main extends Application implements EventHandler {
    int anzahlQuadrate = 100;
    int width = 600;
    int height = 600;
    Pane root = new Pane();
    Scene scene = new Scene(root, width, height);

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Paint");
        ArrayList<Rectangle> al = new ArrayList<Rectangle>();


        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int i = al.size() - 1; i >= 0; i--) {
                    if (al.get(i).contains(new Point2D(event.getX(), event.getY()))) {
                        Rectangle r = al.get(i);
                        r.setFill(Color.WHITE);
                        al.set(i, r);

                    }

                }
            }
        });


        for (int j = 0; j <= anzahlQuadrate; j++) {
            for (int k = 0; k <= anzahlQuadrate; k++) {
                Rectangle r = new Rectangle();
                r.setX(width / anzahlQuadrate * k);
                r.setY(height / anzahlQuadrate * j);
                r.setArcHeight(0);
                r.setArcWidth(0);
                r.setHeight(height / anzahlQuadrate);
                r.setWidth(width / anzahlQuadrate);
               // r.setStrokeType(StrokeType.INSIDE);
               // r.setStrokeWidth(0.6);
              //  r.setStroke(Color.BLACK);
                r.setFill(Color.DARKGRAY);
                al.add(r);
            }
        }

//        al.forEach(r -> r.setArcHeight(0));
//        al.forEach(r -> r.setArcWidth(0));
//        al.forEach(r -> r.setHeight(height/anzahlQuadrate));
//        al.forEach(r -> r.setWidth(width/anzahlQuadrate));
//        al.forEach(r -> r.setStrokeType(StrokeType.INSIDE));
//        al.forEach(r -> r.setStroke(Color.BLACK));


        root.getChildren().addAll(al);


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {

    }
}