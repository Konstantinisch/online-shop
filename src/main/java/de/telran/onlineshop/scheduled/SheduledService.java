package de.telran.onlineshop.scheduled;

import de.telran.onlineshop.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class SheduledService {

    @Autowired
    private ProductsRepository productsRepository;

    @Async//kod metod budet vipolnjatsa v otdelnom potoke
    @Scheduled(initialDelay = 10000,//saderzka starta
            fixedDelay = 5000)//period srabativanija
    public void scheduledTaskfixedDelay() throws InterruptedException {
        log.error("Primer raboti scheduledTask (fixedDelay) -> " + LocalDateTime.now());
        Thread.sleep(3000);
    }

////    @Async//kod metod budet vipolnjatsa v otdelnom potoke
//    @Scheduled(fixedRate= 5000)
    public void scheduledTaskFixedRate() throws InterruptedException {
        log.info("Primer raboti scheduledTask (fixedRate) -> " + LocalDateTime.now());
        Thread.sleep(3000);
    }


    //    @Async//kod metod budet vipolnjatsa v otdelnom potoke
    @Scheduled(cron= "5 * * * * *")
    public void scheduledTaskCron() throws InterruptedException {
        log.info("Primer raboti scheduledTask (cron) -> " + LocalDateTime.now());

    }



}
