package br.com.scc4.tms.service.main.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

    private final String code;
    private final HttpStatus status;
}
