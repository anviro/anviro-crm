package org.anviro.crm.common.beans.authentication;

public class AuthenticationState {

    private boolean successful;
    private boolean blocked;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
