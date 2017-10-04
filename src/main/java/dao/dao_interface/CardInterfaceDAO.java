package dao.dao_interface;

import model.Card;

import java.util.List;

public interface CardInterfaceDAO {
    List<Card> clientCards(int id_client);
    int getAccountId(String numberCard);
}
