package br.com.scc4.tms.tenancy;

import br.com.scc4.tms.tenancy.*;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenancyIdentifierResolver implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_TENANT_ID = "default";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        if (tenantId != null) {
            return tenantId;
        }
        return DEFAULT_TENANT_ID;
    }

    @Override

    public boolean validateExistingCurrentSessions() {
        return true;
    }

}