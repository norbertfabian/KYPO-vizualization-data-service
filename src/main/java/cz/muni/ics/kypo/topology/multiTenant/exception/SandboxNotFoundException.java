package cz.muni.ics.kypo.topology.multiTenant.exception;

/**
 * Thrown when the application cannot look up the sandbox address by it's ID.
 * Created by norbert on 26.9.17.
 */
public class SandboxNotFoundException extends RuntimeException {
    public SandboxNotFoundException() {
        super();
    }

    public SandboxNotFoundException(String s) {
        super(s);
    }

    public SandboxNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SandboxNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
