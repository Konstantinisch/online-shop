package de.telran.onlineshop.scheduled;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync//vkljuchaem mnogopotochnost
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)// let vkljuchat i vikljuchat
public class ScheduledConfig {

}
