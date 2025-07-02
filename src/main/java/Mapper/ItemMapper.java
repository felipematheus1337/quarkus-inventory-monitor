package Mapper;

import Domain.Item;
import Domain.amqp.ItemAMQP;
import Domain.http.ItemHttp;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta-cdi")
public interface ItemMapper {

    ItemHttp toDTO(Item item);

    Item toEntity(ItemHttp itemHttp);

    List<Item> amqpToEntities(List<ItemAMQP> itensAMQP);

    List<ItemHttp> toItemHttpList(List<Item> itens);
}
