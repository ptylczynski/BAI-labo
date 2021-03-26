package cloud.ptl.itemmanager.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/ping")
public class PingController {
    @GetMapping("/time")
    public LocalDateTime getTime(){
        return LocalDateTime.now();
    }
}
