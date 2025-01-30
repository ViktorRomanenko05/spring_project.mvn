package lessons.lesson2;

public class Camera {
    private CameraRoll cameraRoll;

    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void setCameraRoll(ColorCameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void makePhoto() {
        System.out.println("Click!");
        cameraRoll.processing();
    }
}
