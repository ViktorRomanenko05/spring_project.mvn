package lessons.lesson2.spring;

import lessons.lesson2.Camera;
import lessons.lesson2.CameraRoll;
import lessons.lesson2.ColorCameraRoll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CameraRoll cameraRoll (){
        return new ColorCameraRoll();
    }

    @Bean
    public Camera camera (CameraRoll cameraRoll){
        Camera camera = new Camera(cameraRoll);
        return camera;
    }
}
