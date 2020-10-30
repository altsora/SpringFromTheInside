package main.screensaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean("frame", ColorFrame.class).showOnRandomPlace();
            context.getBean("frameTimer", ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}
