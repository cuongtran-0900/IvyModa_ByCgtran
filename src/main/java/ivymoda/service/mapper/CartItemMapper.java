package ivymoda.service.mapper;

import ivymoda.domain.Cart;
import ivymoda.domain.CartItem;
import ivymoda.domain.ProductVariant;
import ivymoda.service.dto.CartDTO;
import ivymoda.service.dto.CartItemDTO;
import ivymoda.service.dto.ProductVariantDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CartItem} and its DTO {@link CartItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface CartItemMapper extends EntityMapper<CartItemDTO, CartItem> {
    @Mapping(target = "productVariant", source = "productVariant", qualifiedByName = "productVariantId")
    @Mapping(target = "cart", source = "cart", qualifiedByName = "cartId")
    CartItemDTO toDto(CartItem s);

    @Named("productVariantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductVariantDTO toDtoProductVariantId(ProductVariant productVariant);

    @Named("cartId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CartDTO toDtoCartId(Cart cart);
}
