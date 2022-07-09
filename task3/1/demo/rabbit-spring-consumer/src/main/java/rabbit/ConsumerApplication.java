package rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import rabbit.bindings.InputMessageBinding;

@SpringBootApplication
@EnableBinding(InputMessageBinding.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @StreamListener(InputMessageBinding.INPUT)
    public void in(String message){
        System.out.println("message = " + message);
    }
}
