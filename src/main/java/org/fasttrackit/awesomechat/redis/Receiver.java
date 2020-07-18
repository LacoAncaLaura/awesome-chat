package org.fasttrackit.awesomechat.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received " + message);
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
