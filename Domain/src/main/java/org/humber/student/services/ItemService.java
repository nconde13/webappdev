package org.humber.student.services;

import org.humber.student.domain.Item;

public interface ItemService {
    Item createItem(Item item);

    boolean deleteItem(Long itemId);

    Item updateItem(Item item);

    Item getItem(Long itemId);
}
