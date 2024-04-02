package edu.unimagdalena.api.entity.mapper;

import edu.unimagdalena.api.entity.Order;
import edu.unimagdalena.api.entity.Payment;
import edu.unimagdalena.api.entity.dto.PaymentDTO;
import edu.unimagdalena.api.entity.enums.PaymentMethod;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T01:48:59-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment paymentDtoToPayment(PaymentDTO paymentDTO) {
        if ( paymentDTO == null ) {
            return null;
        }

        Payment.PaymentBuilder payment = Payment.builder();

        payment.order( paymentDTOToOrder( paymentDTO ) );
        payment.id( paymentDTO.id() );
        payment.paymentDate( paymentDTO.paymentDate() );
        payment.paymentMethod( paymentDTO.paymentMethod() );
        payment.totalPayment( paymentDTO.totalPayment() );

        return payment.build();
    }

    @Override
    public PaymentDTO paymentToPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        Long orderId = null;
        Long id = null;
        Float totalPayment = null;
        LocalDateTime paymentDate = null;
        PaymentMethod paymentMethod = null;

        orderId = paymentOrderId( payment );
        id = payment.getId();
        totalPayment = payment.getTotalPayment();
        paymentDate = payment.getPaymentDate();
        paymentMethod = payment.getPaymentMethod();

        PaymentDTO paymentDTO = new PaymentDTO( id, orderId, totalPayment, paymentDate, paymentMethod );

        return paymentDTO;
    }

    protected Order paymentDTOToOrder(PaymentDTO paymentDTO) {
        if ( paymentDTO == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( paymentDTO.orderId() );

        return order.build();
    }

    private Long paymentOrderId(Payment payment) {
        if ( payment == null ) {
            return null;
        }
        Order order = payment.getOrder();
        if ( order == null ) {
            return null;
        }
        Long id = order.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
