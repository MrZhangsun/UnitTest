package site.zhangsun.unit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Functions: Application
 *
 * @author Murphy Zhang Sun
 * @date 2019-08-05 10:47
 * @since v4.0.1
 */
@MapperScan("site.zhangsun.unit.*.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
