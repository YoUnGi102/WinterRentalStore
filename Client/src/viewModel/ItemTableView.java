package viewModel;

import javafx.beans.property.*;
import model.Item;

public class ItemTableView {

    private StringProperty name;
    private StringProperty type;
    private IntegerProperty size;
    private DoubleProperty price;

    private Item item;

    ItemTableView(Item item){
        this.item = item;
        setItem(item);
    }

    public void setItem(Item item){
        this.name = new SimpleStringProperty(item.getName());
        this.type = new SimpleStringProperty(item.getType());
        this.size = new SimpleIntegerProperty(item.getSize());
        this.price = new SimpleDoubleProperty(item.getPricePerDay());
    }

    public Item getItem() {
        return item;
    }

    public StringProperty nameProperty() {
        return name;
    }
    public StringProperty typeProperty() {
        return type;
    }
    public IntegerProperty sizeProperty() {
        return size;
    }
    public DoubleProperty priceProperty() {
        return price;
    }
}
