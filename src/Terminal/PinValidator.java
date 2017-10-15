package Terminal;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PinValidator {
    private final int pin = 1234;
    private boolean autorized = false;
    private long dateOfBlocking;
    private final int lockTimeInSeconds = 5;
    private boolean accountIsLocked = false;
    private byte incorrectPinCount = 0;

    public int getLockTimeInSeconds () { return lockTimeInSeconds; }

    public boolean isAccountIsLocked () {
        return accountIsLocked;
    }
    public boolean isAutorized () {
        return autorized;
    }

    public long getDateOfBlocking () {
        return dateOfBlocking;
    }

    public void login(int pin) throws AccountIsLockedException, IncorrectPinExceprion {
        if (!accountIsLocked) {
            if (pin == this.pin) {
                autorized = true;
                incorrectPinCount = 0;
            } else {
                incorrectPinCount++;
                if (incorrectPinCount > 2) {
                    accountIsLocked = true;
                    dateOfBlocking = System.currentTimeMillis ();
                }
                throw new IncorrectPinExceprion ("Неверный пин. ");
            }
        } else {
            if (System.currentTimeMillis () - dateOfBlocking > 5 * 1000) {
                accountIsLocked = false;
                login (pin);
            }
            else throw new AccountIsLockedException ("Аккаунт заблокирован на 5 секунд. ", timeToUnlock ());
        }
    }

    public long timeToUnlock(){
        long unlockTime = (dateOfBlocking + lockTimeInSeconds*1000 - System.currentTimeMillis ()) / 1000;
        return unlockTime >= 0 ? unlockTime : 0;
    }
}
