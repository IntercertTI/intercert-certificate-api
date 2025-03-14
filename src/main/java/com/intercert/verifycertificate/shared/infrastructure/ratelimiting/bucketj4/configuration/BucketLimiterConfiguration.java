package com.intercert.verifycertificate.shared.infrastructure.ratelimiting.bucketj4.configuration;


import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


@Configuration
public class BucketLimiterConfiguration {
    @Bean
    public Bucket bucket() {
        // Define the rate limit: 10 requests per minute
        Bandwidth limit = Bandwidth.classic(50, Refill.intervally(50, Duration.ofMinutes(1)));
        return Bucket.builder()
                .addLimit(limit)
                .build();
    }
}
