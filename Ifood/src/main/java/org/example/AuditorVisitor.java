package org.example;

public class AuditorVisitor implements Visitor {
    private String auditoria;

    @Override
    public void visitar(Usuario usuario) {
        auditoria = usuario.getAuditoria();
    }

    public String getAuditoria() {
        return auditoria;
    }
}
