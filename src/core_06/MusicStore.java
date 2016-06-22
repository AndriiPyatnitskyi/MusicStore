package core_06;

import core_06.instruments.Guitar;
import core_06.instruments.Instrument;
import core_06.instruments.Piano;
import core_06.instruments.Trumpet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicStore {
    int guitarQuantity = 10;
    int pianoQuantity = 20;
    int trumpetQuantity = 30;
    Map<Instrument, Integer> stock = new HashMap<>();

    public MusicStore() {
        stock.put(new Guitar(), guitarQuantity);
        stock.put(new Piano(), pianoQuantity);
        stock.put(new Trumpet(), trumpetQuantity);
    }

    public List<Instrument> prepareInstruments(Map<Instrument, Integer> order) {
        List<Instrument> instrumentsToDispatch = new ArrayList<>();
        int quantityOfInstrumentsInOrder;

        for (Map.Entry<Instrument, Integer> entryOfOrder : order.entrySet()) {
            quantityOfInstrumentsInOrder = entryOfOrder.getValue();
            int newQuantity = stock.get(entryOfOrder.getKey()) - quantityOfInstrumentsInOrder;
            stock.put(entryOfOrder.getKey(), newQuantity);
        }

        return instrumentsToDispatch;
    }
}