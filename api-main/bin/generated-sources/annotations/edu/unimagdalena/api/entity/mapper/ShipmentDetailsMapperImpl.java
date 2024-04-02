package edu.unimagdalena.api.entity.mapper;

import edu.unimagdalena.api.entity.Order;
import edu.unimagdalena.api.entity.ShipmentDetails;
import edu.unimagdalena.api.entity.dto.ShipmentDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T01:48:59-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class ShipmentDetailsMapperImpl implements ShipmentDetailsMapper {

    @Override
    public ShipmentDetails shipmentDetailsDtoToShipmentDetails(ShipmentDetailsDTO shipmentDetailsDTO) {
        if ( shipmentDetailsDTO == null ) {
            return null;
        }

        ShipmentDetails.ShipmentDetailsBuilder shipmentDetails = ShipmentDetails.builder();

        shipmentDetails.order( shipmentDetailsDTOToOrder( shipmentDetailsDTO ) );
        shipmentDetails.guideNumber( shipmentDetailsDTO.guideNumber() );
        shipmentDetails.id( shipmentDetailsDTO.id() );
        shipmentDetails.shipmentAddress( shipmentDetailsDTO.shipmentAddress() );
        shipmentDetails.transporter( shipmentDetailsDTO.transporter() );

        return shipmentDetails.build();
    }

    @Override
    public ShipmentDetailsDTO shipmentDetailsToShipmentDetailsDto(ShipmentDetails shipmentDetails) {
        if ( shipmentDetails == null ) {
            return null;
        }

        Long orderId = null;
        Long id = null;
        String shipmentAddress = null;
        String transporter = null;
        Long guideNumber = null;

        orderId = shipmentDetailsOrderId( shipmentDetails );
        id = shipmentDetails.getId();
        shipmentAddress = shipmentDetails.getShipmentAddress();
        transporter = shipmentDetails.getTransporter();
        guideNumber = shipmentDetails.getGuideNumber();

        ShipmentDetailsDTO shipmentDetailsDTO = new ShipmentDetailsDTO( id, orderId, shipmentAddress, transporter, guideNumber );

        return shipmentDetailsDTO;
    }

    protected Order shipmentDetailsDTOToOrder(ShipmentDetailsDTO shipmentDetailsDTO) {
        if ( shipmentDetailsDTO == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( shipmentDetailsDTO.orderId() );

        return order.build();
    }

    private Long shipmentDetailsOrderId(ShipmentDetails shipmentDetails) {
        if ( shipmentDetails == null ) {
            return null;
        }
        Order order = shipmentDetails.getOrder();
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
