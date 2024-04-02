package edu.unimagdalena.api.entity.mapper;

import edu.unimagdalena.api.entity.Customer;
import edu.unimagdalena.api.entity.dto.CustomerDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T01:48:59-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String address = null;

        id = customer.getId();
        name = customer.getName();
        email = customer.getEmail();
        address = customer.getAddress();

        CustomerDTO customerDTO = new CustomerDTO( id, name, email, address );

        return customerDTO;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.address( customerDTO.address() );
        customer.email( customerDTO.email() );
        customer.id( customerDTO.id() );
        customer.name( customerDTO.name() );

        return customer.build();
    }
}
