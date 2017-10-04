package dao.dao_interface;

import model.Status;

import java.math.BigDecimal;

public interface AccountInterfaceDAO {
    void updateBalance(int id_client, BigDecimal balance);
    void changeStatusAccount(Status status, int id_client);
}
