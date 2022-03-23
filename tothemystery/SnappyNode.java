package tothemystery;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;


public class SnappyNode {
    private static final double SNAP_THRESHOLD = 50;

    private final Node parent;
    private final Node node;
    private final Point2D snapPosition;
    private boolean snap;

    private final Node textNode;

    public SnappyNode(Node parent, Node node, Point2D snapPosition) {
        this.textNode = node.lookup("#text");
        Node image = node.lookup("#image");

        this.parent = parent;
        this.node = node;
        this.snapPosition = snapPosition;
        this.snap = false;

        initListeners();
    }

    private void initListeners() {
        parent.layoutXProperty().addListener(observable -> snap());
        parent.layoutYProperty().addListener(observable -> snap());

        node.setOnMouseDragged(this::onDrag);
    }

    private void snap() {
        if (snap) {
            node.setLayoutX(parent.getLayoutX() + snapPosition.getX());
            node.setLayoutY(parent.getLayoutY() + snapPosition.getY());
        }
    }

    private void onDrag(MouseEvent event) {
        final double mouseX = event.getSceneX()  - node.getLayoutBounds().getWidth() / 2;
        final double mouseY = event.getSceneY() - node.getLayoutBounds().getHeight() / 2;

        double snapPointDistance = snapPosition
                .add(parent.getLayoutX(), parent.getLayoutY())
                .distance(mouseX, mouseY);

        snap = snapPointDistance < SNAP_THRESHOLD;
        if (snap) {
            snap();
            textNode.setVisible(false);
        } else {
            node.setLayoutX(mouseX);
            node.setLayoutY(mouseY);

            textNode.setVisible(true);
        }
//        System.out.println(mouseX - parent.getLayoutX());
//        System.out.println(mouseY - parent.getLayoutY());
    }
}
