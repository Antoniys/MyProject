package model;


public class Card {
    private int id;
    private int numberCard; // мб сменить на стринг
    private int id_account;

    public int getId() {
        return id;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;

        Card card = (Card) obj;
        if (this.id != card.id)
            return false;
        return numberCard == card.numberCard;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + numberCard;
        result = 31 * result + id;
        return result;
    }
}
