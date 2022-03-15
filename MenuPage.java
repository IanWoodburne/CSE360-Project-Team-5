package com.restaurant;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class MenuPage extends BorderPane {

    public MenuPage(){

        // load an image
        String filePath = "C:/Users/ianwo/IdeaProjects/restaurant/pictures/freddyfortnite.jpg";

        Image defaultSkin = new Image(filePath);

        ImageView imageView = new ImageView(defaultSkin);

        imageView.setFitHeight(300);
        imageView.setFitWidth(500);

        imageView.setPreserveRatio(true);

        this.setCenter(imageView);

    }

}
