package com.intercert.verifycertificate.shared.application.internal.outboundservices;

import com.intercert.verifycertificate.shared.domain.services.RateLimiterService;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterServiceImpl implements RateLimiterService {

    @Autowired
    private Bucket bucket;

    @Override
    public Boolean allowRequest() {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        return probe.isConsumed();
    }

    @Override
    public Long getRemainingTokens() {
        return bucket.getAvailableTokens();
    }
}
