package dao.dao_realization;

import dao.Connection.ConnectionFactory;
import model.Card;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRealizationDAO  {
    private static final Logger logger = Logger.getLogger(AccountRealizationDAO.class);

    public List<Card> clientCards(int id_client) {
        List<Card> cards = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionFactory.getConnection().prepareStatement("select *from card where id_client=?");
            preparedStatement.setInt(1, id_client);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Card card = new Card();
                card.setNumberCard(resultSet.getInt(2));
                card.setId_account(resultSet.getInt(3));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("Can't get statement or execute query " + e.getMessage());
                }
            }
        }
        return cards;
    }

    public int getAccountId(String numberCard) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionFactory.getConnection().prepareStatement("select id_account from card where number_card=?");
            preparedStatement.setString(1, numberCard);

            ResultSet resultSet = preparedStatement.executeQuery();
            Card card = new Card();
            card.setId_account(resultSet.getInt(3));
            return card.getId_account();
        } catch (SQLException e) {
            logger.error("Can't get statement or execute query " + e.getMessage());
        }
        return 0;
    }
}