package com.timbuchalka;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    //used to add items to our list of all stock items
    public int addStock(StockItem item) {
        if (item != null) { /*if it is null an we got an item pass to us that is null we don;t want to do any processing on it so we wrapping this in a test for not equal to null. */
            //check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item); /*  it's going to get the item if it already exists
            in the map and if it doesn't exist its going to use this item that we actually pass to this method as the item is going to be in stock.
            So either way at the end of this line in stock is going to have an item either the one that has been retirved from the list or the one that
            has been passed to this method. */

            //If there are already stocks on this item, adjust the quantity
            if (inStock != item) { /* by putting in stock != to item we are checking to see did we actually get the list of the item out of
              our map and is that the same as in stock item that has been pass. So by checking to see whether they're separate we can determine basically whether
              the item was already existing in the map because it was already in the map then what we want to do is we want to adjust the stock quantity with
               wahtever the quantity was passed to this method via the item variable on line 15, but if we haven't gone an item that existen in the past
               then we can just used the quantity that's been passed in this.*/
                item.adjustStock(inStock.quantityInStock()); /* they're not the same in other words it already exists in the map prior to the call of
             add stock then we are actually going to pass the value of whatever was already in the map into out current item*/
            }
            list.put(item.getName(), item); /* we are going to get an add entry written to our map and if it alreadt exists automatically
              the .put method will overwrite that is in their. Otherwise if it doesn't exists it's just going to add it like normally it would
              */
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) { /* if in stock is not equal to null and if the
        getQuantityiStuck is >= quantity that we are asking for a to be sold and the quantity that we asked for it has to also be > than 0.
        If all of that is true then we are going to do adjustment.*/
            inStock.adjustStock(-quantity);
            ; /* obivously quantity we determined is going to be a number greater than 0 because we are deducting it
             we are putting a minus in front of the  variable to make sure that the negative amount gets adjusted*/
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item: list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }


    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) { /* so we are going to iterate through the entire map and we are going to
          get each item*/
            StockItem stockItem = item.getValue(); /* that's gonna return singe stockItem*/

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";/*  this is going to be the string formatted*/
            s = s + String.format("%.2f", itemValue) + "\n"; //%.2f use 2 decimal points after the dot "." f= float number
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
