package edu.unimagdalena.api.repositoriesTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.unimagdalena.api.AbstractIntegrationDBTest;
import edu.unimagdalena.api.entity.Order;
import edu.unimagdalena.api.entity.OrderItem;
import edu.unimagdalena.api.entity.Product;
import edu.unimagdalena.api.entity.enums.OrderStatus;
import edu.unimagdalena.api.repository.OrderItemRepository;
import edu.unimagdalena.api.repository.OrderRepository;
import edu.unimagdalena.api.repository.ProductRepository;


public class OrderItemRepositoryTest extends AbstractIntegrationDBTest{

    OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    
    

    @Autowired
    public OrderItemRepositoryTest(OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }

    Order order1 = Order.builder()
                .customer(null)
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.SENT)
                .items(null)
                .payment(null)
                .shipmentDetalis(null)
                .build();
    
    Product product1 = Product.builder()
            .name("sopa")
            .price((float) 5.0)
            .stock(200)
            .orderItems(null)
            .build();

    Product product2 = Product.builder()
            .name("pasta")
            .price((float) 6.0)
            .stock(260)
            .orderItems(null)
            .build();

    OrderItem orderItem1 = OrderItem.builder()
                .order(null)
                .product(null)
                .amount(4)
                .unitPrice((float) 5.0)
                .build();

    OrderItem orderItem2 = OrderItem.builder()
                .order(null)
                .product(null)
                .amount(4)
                .unitPrice((float) 5.0)
                .build();

    

    @BeforeEach
    void setUp() {
        orderItemRepository.deleteAll();
    }

    @Test
    @DisplayName("test save")
    void givenAnOrderItem_WhenSave_ThenOrderItemWithId(){
        //given
        OrderItem OrderItemSaved = orderItemRepository.save(orderItem1);
        //then
        assertThat(OrderItemSaved.getId()).isNotNull();
    }

    @Test
    @DisplayName("test read")
    void givenOrderItems_ThenGetAll(){
        //given
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        List<OrderItem> orderItems = orderItemRepository.findAll();
        //then
        assertThat(orderItems.size()==2);
    }

    @Test
    @DisplayName("test delete")
    void givenIdOrderItem_thenDeleteIt(){
        //given
        orderItemRepository.save(orderItem1);
        Long id = orderItem1.getId();
        //when
        orderItemRepository.deleteById(id);
        //then
        assertThat(orderItemRepository.findById(id)).isEmpty();
    }

    @Test
    @DisplayName("test update")
    void givenAnOrderItem_ThenUpdateThis(){
        //given
        Long id = orderItemRepository.save(orderItem2).getId();
        int newAmount = 10;
        //when
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(null);
        if(orderItem!= null){
            orderItem.setAmount(newAmount);
            OrderItem orderItemUpdate = orderItemRepository.save(orderItem);
            //then
            assertThat(orderItemUpdate.getAmount()==newAmount);
        }
    }

    @Test
    @DisplayName("test findByOrderId")
    void givenOrderItem_ThenFindById(){
        //given
        Long id = order1.getId();
        Order saved = orderRepository.save(order1);
        orderItem1.setOrder(saved);
        orderItem2.setOrder(saved);
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        List<OrderItem> findOrderItem = orderItemRepository.findByOrderId(id);
        //then
        assertThat(findOrderItem.size()==2);
    }

    @Test
    @DisplayName("test findByOrderId")
    void givenOrderItem_ThenfindByProductId(){
        //given
        Long id = product1.getId();
        Product saved = productRepository.save(product1);
        orderItem1.setProduct(saved);
        orderItem2.setProduct(saved);
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        List<OrderItem> findOrderItem = orderItemRepository.findByProductId(id);
        //then
        assertThat(findOrderItem.size()==2);
    }

    @Test
    @DisplayName("test calculateTotalSalesForProduct")
    void givenOrderItem_ThencalculateTotalSalesForProduct(){
        //given
        Long id = product1.getId();
        Product saved = productRepository.save(product1);
        orderItem1.setProduct(saved);
        orderItem2.setProduct(saved);
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        Float totalsales = orderItemRepository.calculateTotalSalesForProduct(id);
        //then
        assertThat(totalsales == 40.0);


    }




}
