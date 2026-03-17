package com.example.domain.sample_domain_1.exception;

import com.example.sharedkernel.exception.DomainException;
import com.example.sharedkernel.exception.ErrorCode;

public class SampleDomainException extends DomainException {
    public SampleDomainException(String message) { super(new ErrorCode("SAMPLE_DOMAIN_ERROR"), message); }
}
