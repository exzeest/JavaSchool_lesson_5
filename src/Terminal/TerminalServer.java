package Terminal;

public class TerminalServer {
    public int getCountOfMoneyOnAccount () {
        return countOfMoneyOnAccount;
    }

    private int countOfMoneyOnAccount;

    public int deposit ( int value ) {
        countOfMoneyOnAccount += value;
        return countOfMoneyOnAccount;
    }

    public int withdraw ( int value ) throws NotEnoughMoneyException {
        if (countOfMoneyOnAccount < value) {
            throw new NotEnoughMoneyException ("Недостаточно золота.");
        }
        countOfMoneyOnAccount -= value;
        return countOfMoneyOnAccount;
    }

}
