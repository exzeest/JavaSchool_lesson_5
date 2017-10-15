package Terminal;

public interface Terminal {
    /*private final TerminalServer server;
    private final PinValidator pinValidator;*/

    /**
     *
     * @return Account balance.
     * @throws AccountIsLockedException
     * @throws IsNotAuthorizedExeption
     */
    int checkAccount () throws AccountIsLockedException, IsNotAuthorizedExeption;

    /**
     *
     * @param valueToWithdraw - Count of money user wants to withdraw.
     * @return Account balance after withdrawing.
     * @throws AccountIsLockedException
     * @throws IsNotAuthorizedExeption
     * @throws NotEnoughMoneyException
     */
    int withdraw(int valueToWithdraw) throws AccountIsLockedException, IsNotAuthorizedExeption, NotEnoughMoneyException, IsNotValidValueException;

    /**
     *
     * @param valueToDeposit - Count of money user wants to deposit.
     * @return Account balance after depositing.
     * @throws AccountIsLockedException
     * @throws IsNotAuthorizedExeption
     */
    int deposit(int valueToDeposit) throws AccountIsLockedException, IsNotAuthorizedExeption, IsNotValidValueException;

    boolean isValidDeposit(int valueToDeposit) throws AccountIsLockedException, IsNotAuthorizedExeption;

    boolean isValidWithdraw(int valueToWithdraw) throws AccountIsLockedException, IsNotAuthorizedExeption;

    boolean isAccountLocked();

    boolean login(int password) throws AccountIsLockedException, IncorrectPinExceprion;


}
