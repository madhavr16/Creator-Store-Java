package in.amantiwari.creatorstore;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;
import java.util.TimeZone;

@SpringBootApplication
public class CreatorStoreApplication {

    public static void main(String[] args) {
        System.setProperty("user.timezone", "Asia/Kolkata");
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));

        System.out.println("TZ env        = " + System.getenv("TZ"));
        System.out.println("user.timezone = " + System.getProperty("user.timezone"));
        System.out.println("Default TZ    = " + TimeZone.getDefault().getID());

        Dotenv dotenv = Dotenv.configure()
                .directory(Paths.get(System.getProperty("user.dir")).toAbsolutePath().toString())
                .ignoreIfMissing()
                .load();
        dotenv.entries().forEach((entry) -> System.setProperty(
                entry.getKey(), entry.getValue()));
        SpringApplication.run(CreatorStoreApplication.class, args);
    }

}
