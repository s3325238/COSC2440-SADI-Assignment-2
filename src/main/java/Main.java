import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.DrugServiceImpl;

/**
 * Created by CoT on 7/29/18.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        context.refresh();

//        DrugServiceImpl drugService = context.getBean(DrugServiceImpl.class);

    }
}
