package Terminal;

public class TerminalImpl implements Terminal {

    private final TerminalServer server = new TerminalServer ();
    private final PinValidator pinValidator = new PinValidator ();

    @Override
    public int checkAccount () throws IsNotAuthorizedExeption, AccountIsLockedException {
        IsAuthorizedAndNotLocked ();
        return server.getCountOfMoneyOnAccount ();
    }

    @Override
    public int withdraw ( int valueToWithdraw ) throws IsNotAuthorizedExeption,
            NotEnoughMoneyException, AccountIsLockedException, IsNotValidValueException {
        IsAuthorizedAndNotLocked ();
        if (!isValidDeposit (valueToWithdraw))
            throw new IsNotValidValueException ("Неправильное количество денег для депозита. Введите сумму кратную 100.");
        return server.withdraw (valueToWithdraw);
    }

    @Override
    public int deposit ( int valueToDeposit ) throws IsNotAuthorizedExeption, AccountIsLockedException, IsNotValidValueException {
        IsAuthorizedAndNotLocked ();
        if (!isValidDeposit (valueToDeposit))
             throw new IsNotValidValueException ("Неправильное количество денег для депозита. Введите сумму кратную 100.");
        return server.deposit (valueToDeposit);
    }

    @Override
    public boolean isValidDeposit ( int valueToDeposit ) throws AccountIsLockedException, IsNotAuthorizedExeption {
        IsAuthorizedAndNotLocked ();
        return valueToDeposit % 100 == 0;
    }

    @Override
    public boolean isValidWithdraw ( int valueToWithdraw ) throws AccountIsLockedException, IsNotAuthorizedExeption {
        IsAuthorizedAndNotLocked ();
        return (valueToWithdraw % 100 == 0) && (server.getCountOfMoneyOnAccount () >= valueToWithdraw);
    }

    @Override
    public boolean isAccountLocked () {
        return pinValidator.isAccountIsLocked ();
    }

    @Override
    public boolean login ( int pin ) throws AccountIsLockedException, IncorrectPinExceprion {
        pinValidator.login (pin);
        return pinValidator.isAutorized ();
    }


    private void IsAuthorizedAndNotLocked () throws AccountIsLockedException, IsNotAuthorizedExeption {
        if (isAccountLocked ()) throw new AccountIsLockedException ("Аккаунт заблокирован.", pinValidator.timeToUnlock ());
        if (!pinValidator.isAutorized ()) throw new IsNotAuthorizedExeption ("Отсутствует авторизация.");
    }
}
