package lessons.lesson2;


public class Client {
    public static void main(String[] args) {
        BlackAndWhiteCameraRoll cameraRoll = new BlackAndWhiteCameraRoll();
        Camera camera = new Camera(cameraRoll);
        //camera.setCameraRoll(cameraRoll);
        camera.makePhoto();

        ColorCameraRoll colorCameraRoll = new ColorCameraRoll();
        camera.setCameraRoll(colorCameraRoll);
        camera.makePhoto();

        // TODO
        // Assistant assistant = new Assistant()
        // Camera camera = assistent.getCamera()
        // camera.makePhoto()
    }
}
