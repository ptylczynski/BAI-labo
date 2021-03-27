package cloud.ptl.itemmanager.common;

import lombok.Builder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionController {
    @Builder
    private static class ExceptionModel{
        private final String reason;
    }

    @ExceptionHandler(Exception.class)
    public ExceptionModel handle(Exception ex){
        return ExceptionModel.builder()
                .reason(ex.getMessage())
                .build();
    }
}
