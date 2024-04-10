package org.humber.student.transformers;


import org.humber.student.domain.Item;
import org.humber.student.repositories.entities.ItemEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class ItemEntityTransformer {

    private ItemEntityTransformer() {
    }

    public static Item transformToItem(ItemEntity itemEntity) {
        return Item.builder()
                .itemId(itemEntity.getItemId())
                .restaurantId(itemEntity.getRestaurant().getRestaurantId())
                .itemName(itemEntity.getItemName())
                .itemCost(itemEntity.getItemCost())
                .build();
    }

    public static List<Item> transformToItems(List<ItemEntity> itemEntities) {
        if(itemEntities == null){
            return null;
        }
        return itemEntities.stream()
                .map(ItemEntityTransformer::transformToItem)
                .collect(Collectors.toList());
    }
}
