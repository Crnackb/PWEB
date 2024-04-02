package edu.unimagdalena.api.entity.mapper;

import edu.unimagdalena.api.entity.Order;
import edu.unimagdalena.api.entity.OrderItem;
import edu.unimagdalena.api.entity.Product;
import edu.unimagdalena.api.entity.dto.OrderItemDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T01:48:59-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemDTO orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        Long orderId = null;
        Long productId = null;
        Long id = null;
        Integer amount = null;
        Float unitPrice = null;

        orderId = orderItemOrderId( orderItem );
        productId = orderItemProductId( orderItem );
        id = orderItem.getId();
        amount = orderItem.getAmount();
        unitPrice = orderItem.getUnitPrice();

        OrderItemDTO orderItemDTO = new OrderItemDTO( id, orderId, productId, amount, unitPrice );

        return orderItemDTO;
    }

    @Override
    public OrderItem orderItemDtoToOrderItem(OrderItemDTO orderItemDTO) {
        if ( orderItemDTO == null ) {
            return null;
        }

        OrderItem.OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.order( orderItemDTOToOrder( orderItemDTO ) );
        orderItem.product( orderItemDTOToProduct( orderItemDTO ) );
        orderItem.amount( orderItemDTO.amount() );
        orderItem.id( orderItemDTO.id() );
        orderItem.unitPrice( orderItemDTO.unitPrice() );

        return orderItem.build();
    }

    private Long orderItemOrderId(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        Order order = orderItem.getOrder();
        if ( order == null ) {
            return null;
        }
        Long id = order.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long orderItemProductId(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        Product product = orderItem.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Order orderItemDTOToOrder(OrderItemDTO orderItemDTO) {
        if ( orderItemDTO == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( orderItemDTO.orderId() );

        return order.build();
    }

    protected Product orderItemDTOToProduct(OrderItemDTO orderItemDTO) {
        if ( orderItemDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( orderItemDTO.productId() );

        return product.build();
    }
}
