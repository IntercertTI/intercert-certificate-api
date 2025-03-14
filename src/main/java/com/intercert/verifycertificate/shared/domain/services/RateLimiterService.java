package com.intercert.verifycertificate.shared.domain.services;

public interface RateLimiterService {
    Boolean allowRequest();
    Long getRemainingTokens();
}
