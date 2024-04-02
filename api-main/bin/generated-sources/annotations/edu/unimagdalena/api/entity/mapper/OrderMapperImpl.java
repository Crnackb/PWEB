package edu.unimagdalena.api.entity.mapper;

import edu.unimagdalena.api.entity.Customer;
import edu.unimagdalena.api.entity.Order;
import edu.unimagdalena.api.entity.dto.OrderDTO;
import edu.unimagdalena.api.entity.enums.OrderStatus;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T01:48:59-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order orderDtoToOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.customer( orderDTOToCustomer( orderDTO ) );
        order.id( orderDTO.id() );
        order.orderDate( orderDTO.orderDate() );
        order.status( orderDTO.status() );

        return order.build();
    }

    @Override
    public OrderDTO orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        Long customerId = null;
        Long id = null;
        LocalDateTime orderDate = null;
        OrderStatus status = null;

        customerId = orderCustomerId( order );
        id = order.getId();
        orderDate = order.getOrderDate();
        status = order.getStatus();

        OrderDTO orderDTO = new OrderDTO( id, customerId, orderDate, status );

        return orderDTO;
    }

    protected Customer orderDTOToCustomer(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( orderDTO.customerId() );

        return customer.build();
    }

    private Long orderCustomerId(Order order) {
        if ( order == null ) {
            return null;
        }
        Customer customer = order.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Long id = customer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
