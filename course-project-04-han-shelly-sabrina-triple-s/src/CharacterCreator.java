
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;


import java.util.List;

import javax.swing.SwingUtilities;

import java.util.ArrayList;

import java.awt.Color;

public class CharacterCreator {
    private CanvasWindow canvas;
    private CharacterBody characterBody;
    private GraphicsGroup character;
    private List<Decoration> availableDecor = new ArrayList<>();
    private GraphicsGroup uiLayer;

    Image selectedDecor = new Image("null");
    private boolean isBeingDragged = false;
    final Point[] dragOffset = {null};
    final boolean[] buttonsAdded = {false};
    double selectedScaleMod = 1;

    

    public CharacterCreator() {
        canvas = new CanvasWindow("Character Creator", 600, 800);

        characterBody = new CharacterBody("images/character/character.PNG");
        character = new GraphicsGroup();
        character.add(characterBody);

        character.setCenter(canvas.getWidth()/2, canvas.getHeight()*0.4);
        character.setScale(0.3);
        
        canvas.add(character);

        uiLayer = new GraphicsGroup();
  
        availableDecor.add(new Hat(100));
        double y = 300;
        for (Decoration decor : availableDecor) {
            addDecorButton(decor, y);
            y += 40;
        }

        Button colorSettingButton = new Button("Color");
        colorSettingButton.setPosition(10, canvas.getHeight()*0.42);
        uiLayer.add(colorSettingButton);

        colorSettingButton.onClick(() -> {
                ColorSetting colorSetting = new ColorSetting(new Color(160, 160, 160), characterBody); // default color
                uiLayer.add(colorSetting);
                
        });

        
        Button savePicButton = new Button("Save Picture!");
        savePicButton.setScale(1.5);
        savePicButton.setCenter(canvas.getWidth()*0.50, canvas.getHeight()*.95);
        uiLayer.add(savePicButton);

        savePicButton.onClick(() -> {
            
            // Terrible hack from Paul. Please report this as a issue
            new Thread(() -> {
                canvas.remove(uiLayer);
                canvas.screenShot("/tmp/yourCharacter.png");
                System.out.println("Saved image to /tmp/yourCharacter.png!" );
                canvas.add(uiLayer);
            }).start();

            
        });

        canvas.add(uiLayer);

        
    }


    private void addDecorButton(Decoration decor, double y) {
        Button button = new Button(decor.getName()); // name of decor type
        button.setPosition(10, y);
        uiLayer.add(button);


        button.onClick(() -> {
            
            for (int i = 0; i < decor.getList().size(); i++) {
                int index = i; 
                Button itemButton = new Button(decor.getType(i)); // individual items
                itemButton.setPosition(120, y + i*40);
                uiLayer.add(itemButton);
                itemButton.onClick(() -> {
                    decor.changeDecor(index); 
                    decor.addDecor(character, characterBody); 
                    enableEditing(canvas, character);
                });
            }
        
        });
    }

    /* handles all of the button functionality for manipulating a decoration  */
    public void enableEditing(CanvasWindow canvas, GraphicsGroup decorLayer) {
        
        final double[] originalPosition = {selectedDecor.getCenter().getX(), selectedDecor.getCenter().getY()};
        
        Button doneButton = new Button("done");
        doneButton.setPosition(canvas.getWidth()*0.7, canvas.getHeight()*0.7);
        Button deleteButton = new Button("delete");
        deleteButton.setPosition(canvas.getWidth()*0.7, canvas.getHeight()*0.7-40);
        Button undoButton = new Button("undo");
        undoButton.setPosition(canvas.getWidth()*0.7, canvas.getHeight()*0.7-80);

        Button increaseButton = new Button("+");
        increaseButton.setPosition(canvas.getWidth()*0.85, canvas.getHeight()*0.7);
        Button decreaseButton = new Button("-");
        decreaseButton.setPosition(canvas.getWidth()*0.85, canvas.getHeight()*0.7-40);


        /* when mouse button is down, check if we can assign the selectedDecor, then enable dragging */
        canvas.onMouseDown(event -> {
            
            Image clickedThing = (Image) canvas.getElementAt(event.getPosition());
            // Check if the clicked object is the current decoration's image
            if (clickedThing instanceof Image && clickedThing != characterBody.getImage()) {
                selectedDecor = (Image) clickedThing;
                
                isBeingDragged = true;
                System.out.println("selectedDecor?");
                System.out.println(selectedDecor);

                dragOffset[0] = new Point(
                event.getPosition().getX() - selectedDecor.getCenter().getX(),
                event.getPosition().getY() - selectedDecor.getCenter().getY());
            }
        });

        canvas.onDrag(event -> {
            if (isBeingDragged && dragOffset[0] != null) {
                double newX = event.getPosition().getX() - dragOffset[0].getX();
                double newY = event.getPosition().getY() - dragOffset[0].getY();
                selectedDecor.setCenter(newX, newY);
            }
        });

        canvas.onMouseUp(event -> {
            isBeingDragged = false; 
            dragOffset[0] = null;
            if (!buttonsAdded[0]) {
                uiLayer.add(doneButton);
                uiLayer.add(deleteButton);
                uiLayer.add(undoButton);
                uiLayer.add(increaseButton);
                uiLayer.add(decreaseButton);
                buttonsAdded[0] = true;
            }
        });

        doneButton.onClick(() -> {
            uiLayer.remove(doneButton);
            uiLayer.remove(deleteButton);
            uiLayer.remove(undoButton);
            uiLayer.remove(increaseButton);
            uiLayer.remove(decreaseButton);
            buttonsAdded[0] = false;
            originalPosition[0] = selectedDecor.getCenter().getX();
            originalPosition[1] = selectedDecor.getCenter().getY();
        });

        deleteButton.onClick(() -> {
            decorLayer.remove(selectedDecor);
            uiLayer.remove(doneButton);
            uiLayer.remove(deleteButton);
            uiLayer.remove(undoButton);
            uiLayer.remove(increaseButton);
            uiLayer.remove(decreaseButton);
            buttonsAdded[0] = false;
        });

        undoButton.onClick(() -> {
            selectedDecor.setCenter(originalPosition[0], originalPosition[1]);
        });

        increaseButton.onClick(() -> {
            selectedScaleMod = selectedDecor.getScaleX();
            selectedScaleMod = selectedScaleMod*1.2;
            selectedDecor.setScale((selectedScaleMod), selectedScaleMod);
        });

        decreaseButton.onClick(() -> {
            selectedScaleMod = selectedDecor.getScaleX();
            selectedScaleMod = selectedScaleMod*0.8;
            selectedDecor.setScale(selectedScaleMod, selectedScaleMod);
        });
     
    
    
    }

    

    public static void main(String[] args) {
        new CharacterCreator();  
    }

    
    
}
